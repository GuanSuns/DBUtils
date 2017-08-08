package org.suns.database.utils.utils;

import org.suns.database.utils.config.DailyAppInspectionConfig;
import org.suns.database.utils.model.DailyAppInspectionModel;

import java.sql.ResultSet;

public class DailyAppModelFiller {

    public static void fill(ResultSet resultSet, DailyAppInspectionModel appModel){
        final String[] fieldNames = DailyAppInspectionConfig.getFieldNames();

        try{
            appModel.setInspectTime(resultSet.getTimestamp(fieldNames[0]));
            appModel.setName(resultSet.getString(fieldNames[1]));
            appModel.setUsageCPU(resultSet.getFloat(fieldNames[2]));
            appModel.setUsageMemory(resultSet.getFloat(fieldNames[3]));
            appModel.setFileSysUsage(resultSet.getFloat(fieldNames[4]));
            appModel.setSvrState(resultSet.getInt(fieldNames[5]));
            appModel.setHoggingCount(resultSet.getFloat(fieldNames[6]));
            appModel.setDataSourceState(resultSet.getInt(fieldNames[7]));
            appModel.setDataSourceConnectionCount(resultSet.getFloat(fieldNames[8]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
