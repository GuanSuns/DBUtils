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
public class Sheet424CoreDao extends AbstractSheetDao{
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
        return Sheet424Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet424Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet424Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet424Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet424Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet424Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet424CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 424 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
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

    public ArrayList<Sheet424CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

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
