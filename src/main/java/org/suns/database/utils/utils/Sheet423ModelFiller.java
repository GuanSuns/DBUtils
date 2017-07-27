package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet423Config;
import org.suns.database.utils.model.Sheet423CoreModel;
import org.suns.database.utils.model.Sheet423PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet423PersonalModel sheet423PersonalModel){
        final String[] personalFieldNames = Sheet423Config.getFieldNames();

        try{
            sheet423PersonalModel.setName2(resultSet.getString(personalFieldNames[0]));
            sheet423PersonalModel.setTotalSpace2((float)resultSet.getInt(personalFieldNames[1]));
            sheet423PersonalModel.setUsedOrRemainSpace2((float)resultSet.getInt(personalFieldNames[2]));
            sheet423PersonalModel.setUsage2(resultSet.getFloat(personalFieldNames[3]));
            sheet423PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[4]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet423CoreModel sheet423CoreModel){

        fillPersonal(resultSet, sheet423CoreModel);
        final String[] fieldNames = Sheet423Config.getFieldNames();

        try{
            sheet423CoreModel.setName3(resultSet.getString(fieldNames[5]));
            sheet423CoreModel.setTotalSpace3((float)resultSet.getInt(fieldNames[6]));
            sheet423CoreModel.setUsedOrRemainSpace3((float)resultSet.getInt(fieldNames[7]));
            sheet423CoreModel.setUsage3(resultSet.getFloat(fieldNames[8]));
            sheet423CoreModel.setName4(resultSet.getString(fieldNames[9]));
            sheet423CoreModel.setTotalSpace4((float)resultSet.getInt(fieldNames[10]));
            sheet423CoreModel.setUsedOrRemainSpace4((float)resultSet.getInt(fieldNames[11]));
            sheet423CoreModel.setUsage4(resultSet.getFloat(fieldNames[12]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
