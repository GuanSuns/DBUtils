package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet426ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet426Config.getCoreTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet426Config.getCoreTableName());
        }
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet426Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet426Config.getCoreSeqName())){
            OracleUtils.createSeq(connection, Sheet426Config.getCoreSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet426Config.getCoreSeqName());
            OracleUtils.createSeq(connection, Sheet426Config.getCoreSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet426Config.getCoreTriggerName()
                , Sheet426Config.getCoreTableName()
                , Sheet426Config.getCoreSeqName()
                , "id");
    }

    public static void addInstance(Sheet426CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 426 Core Model");
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

        String sql = "INSERT INTO " + Sheet426Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4]
                + ", " + fieldNames[5]
                + ", " + fieldNames[6] + "," + fieldNames[7]
                + ", " + fieldNames[8] + "," + fieldNames[9]
                + ", " + fieldNames[10]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, CoreModel.getErrorInfo20());
        psmt.setString(2, CoreModel.getLog20());
        psmt.setInt(3, CoreModel.getErrorInfo21());
        psmt.setString(4, CoreModel.getLog21());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setInt(6, CoreModel.getErrorInfo3());
        psmt.setString(7, CoreModel.getLog3());
        psmt.setInt(8, CoreModel.getErrorInfo40());
        psmt.setString(9, CoreModel.getLog40());
        psmt.setInt(10, CoreModel.getErrorInfo41());
        psmt.setString(11, CoreModel.getLog41());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet426CoreModel> getRecentInstances(int days) throws Exception{
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
            sql = "SELECT * FROM " + Sheet426Config.getCoreTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[4] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet426Config.getCoreTableName()
                    + " WHERE " + fieldNames[4] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet426CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet426CoreModel sheet426CoreModel = new Sheet426CoreModel();
            Sheet426ModelFiller.fillCore(resultSet, sheet426CoreModel);
            resultModels.add(sheet426CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
