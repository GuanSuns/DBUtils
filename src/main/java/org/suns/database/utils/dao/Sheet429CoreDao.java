package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet429Config;
import org.suns.database.utils.model.Sheet429CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet429ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet429Config.getCoreTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet429Config.getCoreTableName());
        }
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet429Config.getCoreSeqName())){
            OracleUtils.createSeq(connection, Sheet429Config.getCoreSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet429Config.getCoreSeqName());
            OracleUtils.createSeq(connection, Sheet429Config.getCoreSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet429Config.getCoreTriggerName()
                , Sheet429Config.getCoreTableName()
                , Sheet429Config.getCoreSeqName()
                , "id");
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet429Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet429CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 429 Core Model");
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

        String[] fieldNames = Sheet429Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet429Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + ", id) " + "VALUES("
                + "?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getHeartBeat1());
        psmt.setTimestamp(2, CoreModel.getInspectTime());
        psmt.setString(3, CoreModel.getHeartBeat2());
        psmt.setString(4, CoreModel.getHeartBeat3());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet429CoreModel> getRecentInstances(int days) throws Exception{
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
            sql = "SELECT * FROM " + Sheet429Config.getCoreTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[1] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet429Config.getCoreTableName()
                    + " WHERE " + fieldNames[1] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet429CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet429CoreModel sheet429CoreModel = new Sheet429CoreModel();
            Sheet429ModelFiller.fillCore(resultSet, sheet429CoreModel);
            resultModels.add(sheet429CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
