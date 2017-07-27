package org.suns.database.utils.dao;

import org.suns.database.utils.config.Sheet423Config;
import org.suns.database.utils.model.Sheet423CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.Sheet423ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreDao extends AbstractSheetDao{
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
        return Sheet423Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet423Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet423Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet423Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet423Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet423Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet423CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 423 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
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
        psmt.setString(1, CoreModel.getName2());
        psmt.setFloat(2, CoreModel.getTotalSpace2());
        psmt.setFloat(3, CoreModel.getUsedOrRemainSpace2());
        psmt.setFloat(4, CoreModel.getUsage2());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(6, CoreModel.getName3());
        psmt.setFloat(7, CoreModel.getTotalSpace3());
        psmt.setFloat(8, CoreModel.getUsedOrRemainSpace3());
        psmt.setFloat(9, CoreModel.getUsage3());
        psmt.setString(10, CoreModel.getName4());
        psmt.setFloat(11, CoreModel.getTotalSpace4());
        psmt.setFloat(12, CoreModel.getUsedOrRemainSpace4());
        psmt.setFloat(13, CoreModel.getUsage4());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet423CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

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
