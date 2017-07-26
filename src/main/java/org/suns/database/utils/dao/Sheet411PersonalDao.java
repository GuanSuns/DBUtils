package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet411Config;
import org.suns.database.utils.model.Sheet411PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet411ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411PersonalDao extends AbstractSheetDao{
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
        return Sheet411Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet411Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet411Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet411Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet411Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet411Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet411PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 411 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] personalFieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + personalFieldNames[0] + "," + personalFieldNames[1]
                + "," + personalFieldNames[2] + "," + personalFieldNames[3]
                + "," + personalFieldNames[4] + "," + personalFieldNames[5]
                + "," + personalFieldNames[6] + "," + personalFieldNames[7]
                + "," + personalFieldNames[8] + "," + personalFieldNames[9]
                + "," + personalFieldNames[10] + "," + personalFieldNames[11]
                + "," + personalFieldNames[12] + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, personalModel.getUsage2());
        psmt.setFloat(2, personalModel.getWeblogicUsage2());
        psmt.setFloat(3, personalModel.getUsage3());
        psmt.setFloat(4, personalModel.getWeblogicUsage3());
        psmt.setFloat(5, personalModel.getUsage4());
        psmt.setFloat(6, personalModel.getWeblogicUsage4());
        psmt.setFloat(7, personalModel.getUsage5());
        psmt.setFloat(8, personalModel.getWeblogicUsage5());
        psmt.setFloat(9, personalModel.getUsage6());
        psmt.setFloat(10, personalModel.getWeblogicUsage6());
        psmt.setFloat(11, personalModel.getUsage7());
        psmt.setFloat(12, personalModel.getWeblogicUsage7());
        psmt.setTimestamp(13, personalModel.getDate());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public ArrayList<Sheet411PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet411PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet411PersonalModel sheet411PersonalModel = new Sheet411PersonalModel();
            Sheet411ModelFiller.fillPersonal(resultSet, sheet411PersonalModel);
            resultModels.add(sheet411PersonalModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
