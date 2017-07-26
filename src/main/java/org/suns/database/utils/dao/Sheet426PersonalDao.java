package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet426ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalDao extends AbstractSheetDao{
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
        return Sheet426Config.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet426Config.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet426Config.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet426Config.getPersonalTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet426Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet426Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet426PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 426 Personal Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, personalModel.getErrorInfo20());
        psmt.setString(2, personalModel.getLog20());
        psmt.setInt(3, personalModel.getErrorInfo21());
        psmt.setString(4, personalModel.getLog21());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet426PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet426PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet426PersonalModel sheet426PersonalModel = new Sheet426PersonalModel();
            Sheet426ModelFiller.fillPersonal(resultSet, sheet426PersonalModel);
            resultModels.add(sheet426PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
