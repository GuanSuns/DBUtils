package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet411Config;
import org.suns.database.utils.model.Sheet411PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet411ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411PersonalDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet411Config.getPersonalTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet411Config.getPersonalTableName());
        }
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet411Config.getPersonalSeqName())){
            OracleUtils.createSeq(connection, Sheet411Config.getPersonalSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet411Config.getPersonalSeqName());
            OracleUtils.createSeq(connection, Sheet411Config.getPersonalSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet411Config.getPersonalTriggerName()
                , Sheet411Config.getPersonalTableName()
                , Sheet411Config.getPersonalSeqName()
                , "id");
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet411Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet411PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 411 Personal Model");
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

        String[] personalFieldNames = Sheet411Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet411Config.getPersonalTableName()
                + " (" + personalFieldNames[0] + "," + personalFieldNames[1]
                + "," + personalFieldNames[2] + "," + personalFieldNames[3]
                + "," + personalFieldNames[4] + "," + personalFieldNames[5]
                + "," + personalFieldNames[6] + "," + personalFieldNames[7]
                + "," + personalFieldNames[8] + "," + personalFieldNames[9]
                + "," + personalFieldNames[10] + "," + personalFieldNames[11]
                + "," + personalFieldNames[12] + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, personalModel.getUsage2());
        psmt.setFloat(2, personalModel.getWeblogicUsage2());
        psmt.setFloat(3, personalModel.getUsage3());
        psmt.setFloat(4, personalModel.getWeblogicUsage3());
        psmt.setFloat(5, personalModel.getUsage4());
        psmt.setFloat(6, personalModel.getWeblogicUsage4());
        psmt.setFloat(7, personalModel.getUsage5());
        psmt.setFloat(8, personalModel.getWeblogicUsage5());
        psmt.setFloat(9, personalModel.getUsage6());
        psmt.setFloat(10, personalModel.getWeblogicUsage6());
        psmt.setFloat(11, personalModel.getUsage7());
        psmt.setFloat(12, personalModel.getWeblogicUsage7());
        psmt.setTimestamp(13, personalModel.getDate());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet411PersonalModel> getRecentInstances(int days) throws Exception{
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

        String[] personalFieldNames = Sheet411Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet411Config.getPersonalTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + personalFieldNames[12] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet411Config.getPersonalTableName()
                    + " WHERE " + personalFieldNames[12] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet411PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet411PersonalModel sheet411PersonalModel = new Sheet411PersonalModel();
            Sheet411ModelFiller.fillPersonal(resultSet, sheet411PersonalModel);
            resultModels.add(sheet411PersonalModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
