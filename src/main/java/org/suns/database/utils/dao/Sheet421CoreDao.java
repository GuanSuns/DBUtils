package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet421ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421CoreDao extends AbstractSheetDao{
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
        return Sheet421Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet421Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet421Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet421Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet421Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet421Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet421CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 421 Core Model");
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
                + "," + fieldNames[10]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, CoreModel.getUsage2());
        psmt.setFloat(2, CoreModel.getU01Usage2());
        psmt.setFloat(3, CoreModel.getGoldUsage2());
        psmt.setFloat(4, CoreModel.getUsage3());
        psmt.setFloat(5, CoreModel.getU01Usage3());
        psmt.setTimestamp(6, CoreModel.getDate());
        psmt.setFloat(7, CoreModel.getUsage4());
        psmt.setFloat(8, CoreModel.getU01Usage4());
        psmt.setFloat(9, CoreModel.getGoldUsage4());
        psmt.setFloat(10, CoreModel.getUsage5());
        psmt.setFloat(11, CoreModel.getU01Usage5());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public ArrayList<Sheet421CoreModel> getRecentInstances(int days)
            throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet421CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet421CoreModel sheet421CoreModel = new Sheet421CoreModel();
            Sheet421ModelFiller.fillCore(resultSet, sheet421CoreModel);
            resultModels.add(sheet421CoreModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
