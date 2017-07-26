package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.config.Sheet422Config;
import org.suns.database.utils.model.Sheet422CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet422ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422CoreDao extends AbstractSheetDao{
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
    protected String getTableName() {
        return Sheet422Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet422Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet422Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet422Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet422Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet422Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet422CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 422 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + "," + fieldNames[5] + "," + fieldNames[6]
                + "," + fieldNames[7] + "," + fieldNames[8]
                + "," + fieldNames[9] + "," + fieldNames[10]
                + "," + fieldNames[11] + "," + fieldNames[12]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getTsName2());
        psmt.setFloat(2, CoreModel.getTsTotalSpace2());
        psmt.setFloat(3, CoreModel.getTsUsedSpace2());
        psmt.setFloat(4, CoreModel.getTsUsage2());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(6, CoreModel.getTsName3());
        psmt.setFloat(7, CoreModel.getTsTotalSpace3());
        psmt.setFloat(8, CoreModel.getTsUsedSpace3());
        psmt.setFloat(9, CoreModel.getTsUsage3());
        psmt.setString(10, CoreModel.getTsName4());
        psmt.setFloat(11, CoreModel.getTsTotalSpace4());
        psmt.setFloat(12, CoreModel.getTsUsedSpace4());
        psmt.setFloat(13, CoreModel.getTsUsage4());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public ArrayList<Sheet422CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet422CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet422CoreModel sheet422CoreModel = new Sheet422CoreModel();
            Sheet422ModelFiller.fillCore(resultSet, sheet422CoreModel);
            resultModels.add(sheet422CoreModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
