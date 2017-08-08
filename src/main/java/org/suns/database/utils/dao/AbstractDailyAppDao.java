package org.suns.database.utils.dao;

import org.suns.database.utils.config.DailyAppInspectionConfig;
import org.suns.database.utils.model.DailyAppInspectionModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.DailyAppModelFiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class AbstractDailyAppDao extends AbstractSheetDao{

    @Override
    protected String[] getFieldNames() {
        return DailyAppInspectionConfig.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return DailyAppInspectionConfig.getTimeFieldIndex();
    }

    public void addInstance(DailyAppInspectionModel appModel) throws Exception{
        if(appModel == null){
            throw new Exception("Uninitialized Daily App Inspection Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4] + "," + fieldNames[5]
                + ", " + fieldNames[6] + "," + fieldNames[7]
                + ", " + fieldNames[8]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setTimestamp(1, appModel.getInspectTime());
        psmt.setString(2, appModel.getName());
        psmt.setFloat(3, appModel.getUsageCPU());
        psmt.setFloat(4, appModel.getUsageMemory());
        psmt.setFloat(5, appModel.getFileSysUsage());
        psmt.setInt(6, appModel.getSvrState());
        psmt.setFloat(7, appModel.getHoggingCount());
        psmt.setInt(8, appModel.getDataSourceState());
        psmt.setFloat(9, appModel.getDataSourceConnectionCount());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<DailyAppInspectionModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<DailyAppInspectionModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            DailyAppInspectionModel appModel = new DailyAppInspectionModel();
            DailyAppModelFiller.fill(resultSet, appModel);
            resultModels.add(appModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
