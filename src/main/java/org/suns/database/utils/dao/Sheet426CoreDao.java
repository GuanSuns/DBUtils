package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet426ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreDao extends AbstractSheetDao{
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
        return Sheet426Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet426Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet426Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet426Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet426Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet426Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet426CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 426 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4]
                + ", " + fieldNames[5]
                + ", " + fieldNames[6] + "," + fieldNames[7]
                + ", " + fieldNames[8] + "," + fieldNames[9]
                + ", " + fieldNames[10]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, CoreModel.getErrorInfo20());
        psmt.setString(2, CoreModel.getLog20());
        psmt.setInt(3, CoreModel.getErrorInfo21());
        psmt.setString(4, CoreModel.getLog21());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setInt(6, CoreModel.getErrorInfo3());
        psmt.setString(7, CoreModel.getLog3());
        psmt.setInt(8, CoreModel.getErrorInfo40());
        psmt.setString(9, CoreModel.getLog40());
        psmt.setInt(10, CoreModel.getErrorInfo41());
        psmt.setString(11, CoreModel.getLog41());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet426CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet426CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet426CoreModel sheet426CoreModel = new Sheet426CoreModel();
            Sheet426ModelFiller.fillCore(resultSet, sheet426CoreModel);
            resultModels.add(sheet426CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
