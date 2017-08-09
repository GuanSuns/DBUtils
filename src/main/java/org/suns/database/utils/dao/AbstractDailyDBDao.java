package org.suns.database.utils.dao;

import org.suns.database.utils.config.DailyDBInspectionConfig;
import org.suns.database.utils.model.DailyDBInspectionModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.DailyDBModelFiller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class AbstractDailyDBDao extends AbstractSheetDao {
    @Override
    protected String[] getFieldNames() {
        return DailyDBInspectionConfig.getFieldNames();
    }

    @Override
    protected int getTimeFieldIndex() {
        return DailyDBInspectionConfig.getTimeFieldIndex();
    }

    public void addInstance(DailyDBInspectionModel dbModel) throws Exception{
        if(dbModel == null){
            throw new Exception("Uninitialized Daily DB Inspection Model");
        }

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();

        String sql = "INSERT INTO " + getTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4] + "," + fieldNames[5]
                + ", " + fieldNames[6] + "," + fieldNames[7]
                + ", " + fieldNames[8] + "," + fieldNames[9]
                + "," + fieldNames[10]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setTimestamp(1, dbModel.getInspectTime());
        psmt.setString(2, dbModel.getName());
        psmt.setFloat(3, dbModel.getUsageCPU());
        psmt.setFloat(4, dbModel.getUsageMemory());
        psmt.setFloat(5, dbModel.getUsageArchiveSpace());
        psmt.setInt(6, dbModel.getHasLongTermLock());
        psmt.setInt(7, dbModel.getHasOverloadTableSpace());
        psmt.setInt(8, dbModel.getHasErrorInLog());
        psmt.setFloat(9, dbModel.getDiskBusy());
        psmt.setInt(10, dbModel.getHasOggError());
        psmt.setInt(11, dbModel.getHasOggDelay());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public ArrayList<DailyDBInspectionModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        ResultSet resultSet = selectRecentInstances(connection, days);

        ArrayList<DailyDBInspectionModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            DailyDBInspectionModel appModel = new DailyDBInspectionModel();
            DailyDBModelFiller.fill(resultSet, appModel);
            resultModels.add(appModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
