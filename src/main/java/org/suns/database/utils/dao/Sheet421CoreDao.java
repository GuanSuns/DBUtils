package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet421ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421CoreDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection, Sheet421Config.getCoreTableName());
        }else{
            return OracleUtils.checkTableExisted(connection, Sheet421Config.getCoreTableName());
        }
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet421Config.getCoreSeqName())){
            OracleUtils.createSeq(connection, Sheet421Config.getCoreSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet421Config.getCoreSeqName());
            OracleUtils.createSeq(connection, Sheet421Config.getCoreSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet421Config.getCoreTriggerName()
                , Sheet421Config.getCoreTableName()
                , Sheet421Config.getCoreSeqName()
                , "id");
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet421Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet421CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 421 Core Model");
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

        String sql = "INSERT INTO " + Sheet421Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + "," + fieldNames[6] + "," + fieldNames[7]
                + "," + fieldNames[8] + "," + fieldNames[9]
                + "," + fieldNames[10]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, CoreModel.getUsage2());
        psmt.setFloat(2, CoreModel.getU01Usage2());
        psmt.setFloat(3, CoreModel.getGoldUsage2());
        psmt.setFloat(4, CoreModel.getUsage3());
        psmt.setFloat(5, CoreModel.getU01Usage3());
        psmt.setTimestamp(6, CoreModel.getDate());
        psmt.setFloat(7, CoreModel.getUsage4());
        psmt.setFloat(8, CoreModel.getU01Usage4());
        psmt.setFloat(9, CoreModel.getGoldUsage4());
        psmt.setFloat(10, CoreModel.getUsage5());
        psmt.setFloat(11, CoreModel.getU01Usage5());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet421CoreModel> getRecentInstances(int days)
            throws Exception{
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
            sql = "SELECT * FROM " + Sheet421Config.getCoreTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[5] + ")"
                    + " ORDER BY ID ASC";
        }else{
            sql = "SELECT * FROM " + Sheet421Config.getCoreTableName()
                    + " WHERE " + fieldNames[5] + ">SYSDATE-" + days
                    + " ORDER BY ID ASC";
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet421CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet421CoreModel sheet421CoreModel = new Sheet421CoreModel();
            Sheet421ModelFiller.fillCore(resultSet, sheet421CoreModel);
            resultModels.add(sheet421CoreModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
