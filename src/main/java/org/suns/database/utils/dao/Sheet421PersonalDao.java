package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.model.Sheet421PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet421ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet421Config.getPersonalTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet421Config.getPersonalTableName());
        }
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet421Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet421Config.getPersonalSeqName())){
            OracleUtils.createSeq(connection, Sheet421Config.getPersonalSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet421Config.getPersonalSeqName());
            OracleUtils.createSeq(connection, Sheet421Config.getPersonalSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet421Config.getPersonalTriggerName()
                , Sheet421Config.getPersonalTableName()
                , Sheet421Config.getPersonalSeqName()
                , "id");
    }

    public static void addInstance(Sheet421PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 421 Personal Model");
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

        String[] fieldNames = Sheet421Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet421Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, personalModel.getUsage2());
        psmt.setFloat(2, personalModel.getU01Usage2());
        psmt.setFloat(3, personalModel.getGoldUsage2());
        psmt.setFloat(4, personalModel.getUsage3());
        psmt.setFloat(5, personalModel.getU01Usage3());
        psmt.setTimestamp(6, personalModel.getDate());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet421PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet421Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet421Config.getPersonalTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[5] + ")"
                    + " ORDER BY ID ASC";
        }else{
            sql = "SELECT * FROM " + Sheet421Config.getPersonalTableName()
                    + " WHERE " + fieldNames[5] + ">SYSDATE-" + days
                    + " ORDER BY ID ASC";
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet421PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet421PersonalModel sheet421PersonalModel = new Sheet421PersonalModel();
            Sheet421ModelFiller.fillPersonal(resultSet, sheet421PersonalModel);
            resultModels.add(sheet421PersonalModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
