package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet428Config;
import org.suns.database.utils.model.Sheet428CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet428ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428CoreDao extends AbstractSheetDao{
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
        return Sheet428Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet428Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet428Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet428Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet428Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet428Config.getTimeFieldIndex();
    }


    public void addInstance(Sheet428CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 428 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4]
                + ", " + fieldNames[5]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getStatus1());
        psmt.setString(2, CoreModel.getStatus2());
        psmt.setString(3, CoreModel.getStatus3());
        psmt.setString(4, CoreModel.getStatus4());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(6, CoreModel.getStatus5());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet428CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet428CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet428CoreModel sheet428CoreModel = new Sheet428CoreModel();
            Sheet428ModelFiller.fillCore(resultSet, sheet428CoreModel);
            resultModels.add(sheet428CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
