package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet429Config;
import org.suns.database.utils.model.Sheet429CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.database.utils.utils.Sheet429ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreDao extends AbstractSheetDao{
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
        return Sheet429Config.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return Sheet429Config.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return Sheet429Config.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return Sheet429Config.getCoreTriggerName();
    }

    @Override
    protected String[] getFieldNames() {
        return Sheet429Config.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return Sheet429Config.getTimeFieldIndex();
    }

    public void addInstance(Sheet429CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 429 Core Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + ", id) " + "VALUES("
                + "?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getHeartBeat1());
        psmt.setTimestamp(2, CoreModel.getInspectTime());
        psmt.setString(3, CoreModel.getHeartBeat2());
        psmt.setString(4, CoreModel.getHeartBeat3());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<Sheet429CoreModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<Sheet429CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet429CoreModel sheet429CoreModel = new Sheet429CoreModel();
            Sheet429ModelFiller.fillCore(resultSet, sheet429CoreModel);
            resultModels.add(sheet429CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
