package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet411Config;
import org.suns.database.utils.model.Sheet411CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet411ModelFiller;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411CoreDao extends AbstractSheetDao{
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    @Override
    public void setTableExist(boolean isExist) {
        tableExisted = isExist;
    }

    @Override
    public void setSequenceAndTriggerExisted(boolean isExist) {
        sequenceAndTriggerExisted = isExist;
    }

    @Override
    public boolean isTableExist() {
        return tableExisted;
    }

    @Override
    public boolean isSequenceAndTriggerExisted() {
        return sequenceAndTriggerExisted;
    }

    @Override
    public boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection, Sheet411Config.getCoreTableName());
        }else{
            return OracleUtils.checkTableExisted(connection, Sheet411Config.getCoreTableName());
        }
    }

    @Override
    public void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet411Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    @Override
    public void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, Sheet411Config.getCoreSeqName())){
            OracleUtils.createSeq(connection, Sheet411Config.getCoreSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, Sheet411Config.getCoreSeqName());
            OracleUtils.createSeq(connection, Sheet411Config.getCoreSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , Sheet411Config.getCoreTriggerName()
                , Sheet411Config.getCoreTableName()
                , Sheet411Config.getCoreSeqName()
                , "id");
    }

    public void addInstance(Sheet411CoreModel coreModel) throws Exception{
        if(coreModel == null){
            throw new Exception("Uninitialized Sheet 411 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = Sheet411Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet411Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + "," + fieldNames[6] + "," + fieldNames[7]
                + "," + fieldNames[8] + "," + fieldNames[9]
                + "," + fieldNames[10] + "," + fieldNames[11]
                + "," + fieldNames[12] + "," + fieldNames[13]
                + "," + fieldNames[14] + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, coreModel.getUsage2());
        psmt.setFloat(2, coreModel.getWeblogicUsage2());
        psmt.setFloat(3, coreModel.getUsage3());
        psmt.setFloat(4, coreModel.getWeblogicUsage3());
        psmt.setFloat(5, coreModel.getUsage4());
        psmt.setFloat(6, coreModel.getWeblogicUsage4());
        psmt.setFloat(7, coreModel.getUsage5());
        psmt.setFloat(8, coreModel.getWeblogicUsage5());
        psmt.setFloat(9, coreModel.getUsage6());
        psmt.setFloat(10, coreModel.getWeblogicUsage6());
        psmt.setFloat(11, coreModel.getUsage7());
        psmt.setFloat(12, coreModel.getWeblogicUsage7());
        psmt.setTimestamp(13, coreModel.getDate());
        psmt.setFloat(14, coreModel.getUsage8());
        psmt.setFloat(15, coreModel.getWeblogicUsage8());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public ArrayList<Sheet411CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = Sheet411Config.getFieldNames();
        ResultSet resultSet = selectRecentInstances(connection, days
                , fieldNames[12], Sheet411Config.getCoreTableName());

        ArrayList<Sheet411CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet411CoreModel sheet411CoreModel = new Sheet411CoreModel();
            Sheet411ModelFiller.fillCore(resultSet, sheet411CoreModel);
            resultModels.add(sheet411CoreModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }

    public void abortRecentInstances(int minutes) throws Exception{
        //Invalid argument
        if(minutes < 0) return;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = Sheet411Config.getFieldNames();
        deleteRecentInstances(connection, minutes
                , fieldNames[12], Sheet411Config.getCoreTableName());

        DBUtils.closeConnection();
    }
}
