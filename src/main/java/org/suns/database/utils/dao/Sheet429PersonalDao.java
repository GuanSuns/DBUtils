package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet429Config;
import org.suns.database.utils.model.Sheet429PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet429ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429PersonalDao extends AbstractSheetDao{
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
        return Sheet429Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet429Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet429Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet429Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet429Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet429Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet429PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 429 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = Sheet429Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet429Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", id) " + "VALUES("
                + "?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getHeartBeat1());
        psmt.setTimestamp(2, personalModel.getInspectTime());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet429PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet429PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet429PersonalModel sheet429PersonalModel = new Sheet429PersonalModel();
            Sheet429ModelFiller.fillPersonal(resultSet, sheet429PersonalModel);
            resultModels.add(sheet429PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
