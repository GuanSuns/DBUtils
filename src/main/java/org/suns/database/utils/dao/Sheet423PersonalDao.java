package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet423Config;
import org.suns.database.utils.model.Sheet423PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet423ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet423Config.getPersonalTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet423Config.getPersonalTableName());
        }
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet423Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet423Config.getPersonalSeqName())){
            OracleUtils.createSeq(connection, Sheet423Config.getPersonalSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet423Config.getPersonalSeqName());
            OracleUtils.createSeq(connection, Sheet423Config.getPersonalSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet423Config.getPersonalTriggerName()
                , Sheet423Config.getPersonalTableName()
                , Sheet423Config.getPersonalSeqName()
                , "id");
    }

    public static void addInstance(Sheet423PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 423 Personal Model");
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

        String[] fieldNames = Sheet423Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet423Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getAsmName2());
        psmt.setFloat(2, personalModel.getTotalSpace2());
        psmt.setFloat(3, personalModel.getRemainSpace2());
        psmt.setFloat(4, personalModel.getUsage2());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet423PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet423Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet423Config.getPersonalTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[4] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet423Config.getPersonalTableName()
                    + " WHERE " + fieldNames[4] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet423PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet423PersonalModel sheet423PersonalModel = new Sheet423PersonalModel();
            Sheet423ModelFiller.fillPersonal(resultSet, sheet423PersonalModel);
            resultModels.add(sheet423PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
