package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet423Config;
import org.suns.database.utils.model.Sheet423PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet423ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalDao extends AbstractSheetDao{
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
        return Sheet423Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet423Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet423Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet423Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet423Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet423Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet423PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 423 Personal Model");
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
        psmt.setString(1, personalModel.getAsmName2());
        psmt.setFloat(2, personalModel.getTotalSpace2());
        psmt.setFloat(3, personalModel.getRemainSpace2());
        psmt.setFloat(4, personalModel.getUsage2());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet423PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet423PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet423PersonalModel sheet423PersonalModel = new Sheet423PersonalModel();
            Sheet423ModelFiller.fillPersonal(resultSet, sheet423PersonalModel);
            resultModels.add(sheet423PersonalModel);
        }
    
        DBUtils.closeConnection();

        return resultModels;
    }
}
