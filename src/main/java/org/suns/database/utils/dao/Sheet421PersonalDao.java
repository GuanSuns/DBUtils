package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.model.Sheet421PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet421ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalDao extends AbstractSheetDao{
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
        return Sheet421Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet421Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet421Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet421Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet421Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet421Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet421PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 421 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, personalModel.getUsage2());
        psmt.setFloat(2, personalModel.getU01Usage2());
        psmt.setFloat(3, personalModel.getGoldUsage2());
        psmt.setFloat(4, personalModel.getUsage3());
        psmt.setFloat(5, personalModel.getU01Usage3());
        psmt.setTimestamp(6, personalModel.getDate());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public ArrayList<Sheet421PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet421PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet421PersonalModel sheet421PersonalModel = new Sheet421PersonalModel();
            Sheet421ModelFiller.fillPersonal(resultSet, sheet421PersonalModel);
            resultModels.add(sheet421PersonalModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
