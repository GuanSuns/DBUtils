package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet422Config;
import org.suns.database.utils.model.Sheet422PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet422ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet422Config.getPersonalTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet422Config.getPersonalTableName());
        }
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet422Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet422Config.getPersonalSeqName())){
            OracleUtils.createSeq(connection, Sheet422Config.getPersonalSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet422Config.getPersonalSeqName());
            OracleUtils.createSeq(connection, Sheet422Config.getPersonalSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet422Config.getPersonalTriggerName()
                , Sheet422Config.getPersonalTableName()
                , Sheet422Config.getPersonalSeqName()
                , "id");
    }

    public static void addInstance(Sheet422PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 422 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        boolean dropSeqFlag = false;

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
                dropSeqFlag = true;
            }
            tableExisted = true;
        }
        if(!sequenceAndTriggerExisted && DBConfig.getDbType().equals(DBType.oracle)){
            checkSequenceAndTriggerExisted(connection, dropSeqFlag);
            sequenceAndTriggerExisted = true;
        }

        String[] fieldNames = Sheet422Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet422Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getTsName2());
        psmt.setFloat(2, personalModel.getTsTotalSpace2());
        psmt.setFloat(3, personalModel.getTsUsedSpace2());
        psmt.setFloat(4, personalModel.getTsUsage2());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet422PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
                tableExisted = true;

                DBUtils.closeConnection();
                return null;
            }
            tableExisted = true;
        }

        final String[] fieldNames = Sheet422Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet422Config.getPersonalTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[4] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet422Config.getPersonalTableName()
                    + " WHERE " + fieldNames[4] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet422PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet422PersonalModel sheet422PersonalModel = new Sheet422PersonalModel();
            Sheet422ModelFiller.fillPersonal(resultSet, sheet422PersonalModel);
            resultModels.add(sheet422PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
