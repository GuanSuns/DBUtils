package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet424Config;
import org.suns.database.utils.model.Sheet424PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet424ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424PersonalDao extends AbstractSheetDao{
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
        return Sheet424Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet424Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet424Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet424Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet424Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet424Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet424PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 424 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2]
                + ", id) " + "VALUES("
                + "?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setTimestamp(1, personalModel.getInspectTime2());
        psmt.setString(2, personalModel.getStatus2());
        psmt.setTimestamp(3, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet424PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet424PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet424PersonalModel sheet424PersonalModel = new Sheet424PersonalModel();
            Sheet424ModelFiller.fillPersonal(resultSet, sheet424PersonalModel);
            resultModels.add(sheet424PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
