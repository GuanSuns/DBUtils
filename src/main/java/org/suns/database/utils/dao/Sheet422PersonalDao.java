package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet422Config;
import org.suns.database.utils.model.Sheet422PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet422ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalDao extends AbstractSheetDao{
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
        return Sheet422Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet422Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet422Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet422Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet422Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet422Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet422PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 422 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getTsName2());
        psmt.setFloat(2, personalModel.getTsTotalSpace2());
        psmt.setFloat(3, personalModel.getTsUsedSpace2());
        psmt.setFloat(4, personalModel.getTsUsage2());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet422PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet422PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet422PersonalModel sheet422PersonalModel = new Sheet422PersonalModel();
            Sheet422ModelFiller.fillPersonal(resultSet, sheet422PersonalModel);
            resultModels.add(sheet422PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
