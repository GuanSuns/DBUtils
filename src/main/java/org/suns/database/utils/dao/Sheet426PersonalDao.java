package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet426ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet426Config.getPersonalTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet426Config.getPersonalTableName());
        }
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet426Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet426Config.getPersonalSeqName())){
            OracleUtils.createSeq(connection, Sheet426Config.getPersonalSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet426Config.getPersonalSeqName());
            OracleUtils.createSeq(connection, Sheet426Config.getPersonalSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet426Config.getPersonalTriggerName()
                , Sheet426Config.getPersonalTableName()
                , Sheet426Config.getPersonalSeqName()
                , "id");
    }

    public static void addInstance(Sheet426PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 426 Personal Model");
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

        String[] fieldNames = Sheet426Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet426Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, personalModel.getErrorInfo20());
        psmt.setString(2, personalModel.getLog20());
        psmt.setInt(3, personalModel.getErrorInfo21());
        psmt.setString(4, personalModel.getLog21());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet426PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet426Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet426Config.getPersonalTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[4] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet426Config.getPersonalTableName()
                    + " WHERE " + fieldNames[4] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet426PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet426PersonalModel sheet426PersonalModel = new Sheet426PersonalModel();
            Sheet426ModelFiller.fillPersonal(resultSet, sheet426PersonalModel);
            resultModels.add(sheet426PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
