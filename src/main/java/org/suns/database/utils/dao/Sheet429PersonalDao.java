package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet429Config;
import org.suns.database.utils.model.Sheet429PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet429ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429PersonalDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet429Config.getPersonalTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet429Config.getPersonalTableName());
        }
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet429Config.getPersonalSeqName())){
            OracleUtils.createSeq(connection, Sheet429Config.getPersonalSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet429Config.getPersonalSeqName());
            OracleUtils.createSeq(connection, Sheet429Config.getPersonalSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet429Config.getPersonalTriggerName()
                , Sheet429Config.getPersonalTableName()
                , Sheet429Config.getPersonalSeqName()
                , "id");
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet429Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet429PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 429 Personal Model");
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
        if(!sequenceAndTriggerExisted){
            checkSequenceAndTriggerExisted(connection, dropSeqFlag);
            sequenceAndTriggerExisted = true;
        }

        String[] fieldNames = Sheet429Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet429Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", id) " + "VALUES("
                + "?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getHeartBeat1());
        psmt.setTimestamp(2, personalModel.getInspectTime());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet429PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet429Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet429Config.getPersonalTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[1] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet429Config.getPersonalTableName()
                    + " WHERE " + fieldNames[1] + ">SYSDATE-" + days;
        }
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet429PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet429PersonalModel sheet429PersonalModel = new Sheet429PersonalModel();
            Sheet429ModelFiller.fillPersonal(resultSet, sheet429PersonalModel);
            resultModels.add(sheet429PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
