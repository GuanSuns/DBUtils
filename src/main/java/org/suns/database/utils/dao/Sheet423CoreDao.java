package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet423Config;
import org.suns.database.utils.model.Sheet423CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet423ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreDao {
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection
                    , Sheet423Config.getCoreTableName());
        }else{
            return OracleUtils.checkTableExisted(connection
                    , Sheet423Config.getCoreTableName());
        }
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet423Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    private static void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet423Config.getCoreSeqName())){
            OracleUtils.createSeq(connection, Sheet423Config.getCoreSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet423Config.getCoreSeqName());
            OracleUtils.createSeq(connection, Sheet423Config.getCoreSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet423Config.getCoreTriggerName()
                , Sheet423Config.getCoreTableName()
                , Sheet423Config.getCoreSeqName()
                , "id");
    }

    public static void addInstance(Sheet423CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 423 Core Model");
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

        String[] fieldNames = Sheet423Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet423Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + "," + fieldNames[6] + "," + fieldNames[7]
                + "," + fieldNames[8] + "," + fieldNames[9]
                + "," + fieldNames[10] + "," + fieldNames[11]
                + "," + fieldNames[12]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getAsmName2());
        psmt.setFloat(2, CoreModel.getTotalSpace2());
        psmt.setFloat(3, CoreModel.getRemainSpace2());
        psmt.setFloat(4, CoreModel.getUsage2());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(6, CoreModel.getAsmName3());
        psmt.setFloat(7, CoreModel.getTotalSpace3());
        psmt.setFloat(8, CoreModel.getRemainSpace3());
        psmt.setFloat(9, CoreModel.getUsage3());
        psmt.setString(10, CoreModel.getAsmName4());
        psmt.setFloat(11, CoreModel.getTotalSpace4());
        psmt.setFloat(12, CoreModel.getRemainSpace4());
        psmt.setFloat(13, CoreModel.getUsage4());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet423CoreModel> getRecentInstances(int days) throws Exception{
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
            sql = "SELECT * FROM " + Sheet423Config.getCoreTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + fieldNames[4] + ")";
        }else{
            sql = "SELECT * FROM " + Sheet423Config.getCoreTableName()
                    + " WHERE " + fieldNames[4] + ">SYSDATE-" + days;
        }

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet423CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            Sheet423ModelFiller.fillCore(resultSet, sheet423CoreModel);
            resultModels.add(sheet423CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
