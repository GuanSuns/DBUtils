package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet424Config;
import org.suns.database.utils.model.Sheet424CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet424ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424CoreDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet424Config.getCoreTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet424Config.getCoreTableName());
        }
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet424Config.getCoreSeqName())){
            OracleUtils.createSeq(connection, Sheet424Config.getCoreSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet424Config.getCoreSeqName());
            OracleUtils.createSeq(connection, Sheet424Config.getCoreSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet424Config.getCoreTriggerName()
                , Sheet424Config.getCoreTableName()
                , Sheet424Config.getCoreSeqName()
                , "id");
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet424Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet424CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 424 Core Model");
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

        String[] fieldNames = Sheet424Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet424Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2]
                + "," + fieldNames[3] + "," + fieldNames[4]
                + "," + fieldNames[5] + "," + fieldNames[6]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setTimestamp(1, CoreModel.getInspectTime2());
        psmt.setString(2, CoreModel.getStatus2());
        psmt.setTimestamp(3, CoreModel.getDate());
        psmt.setTimestamp(4, CoreModel.getInspectTime3());
        psmt.setString(5, CoreModel.getStatus3());
        psmt.setTimestamp(6, CoreModel.getInspectTime4());
        psmt.setString(7, CoreModel.getStatus4());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet424CoreModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet424Config.getFieldNames();

        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + Sheet424Config.getCoreTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[2] + ")"
                    + " ORDER BY ID ASC";
        }else{
            sql = "SELECT * FROM " + Sheet424Config.getCoreTableName()
                    + " WHERE " + fieldNames[2] + ">SYSDATE-" + days
                    + " ORDER BY ID ASC";
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet424CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet424CoreModel sheet424CoreModel = new Sheet424CoreModel();
            Sheet424ModelFiller.fillCore(resultSet, sheet424CoreModel);
            resultModels.add(sheet424CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
