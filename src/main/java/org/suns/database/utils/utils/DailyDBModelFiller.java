package org.suns.database.utils.utils;

import org.suns.database.utils.config.DailyDBInspectionConfig;
import org.suns.database.utils.model.DailyDBInspectionModel;

import java.sql.ResultSet;

public class DailyDBModelFiller {

    public static void fill(ResultSet resultSet, DailyDBInspectionModel dbModel){
        final String[] fieldNames = DailyDBInspectionConfig.getFieldNames();

        try{
            dbModel.setInspectTime(resultSet.getTimestamp(fieldNames[0]));
            dbModel.setName(resultSet.getString(fieldNames[1]));
            dbModel.setUsageCPU(resultSet.getFloat(fieldNames[2]));
            dbModel.setUsageMemory(resultSet.getFloat(fieldNames[3]));
            dbModel.setUsageArchiveSpace(resultSet.getFloat(fieldNames[4]));
            dbModel.setHasLongTermLock(resultSet.getInt(fieldNames[5]));
            dbModel.setHasOverloadTableSpace(resultSet.getInt(fieldNames[6]));
            dbModel.setHasErrorInLog(resultSet.getInt(fieldNames[7]));
            dbModel.setDiskBusy(resultSet.getFloat(fieldNames[8]));
            dbModel.setHasOggError(resultSet.getInt(fieldNames[9]));
            dbModel.setHasOggDelay(resultSet.getInt(fieldNames[10]));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
