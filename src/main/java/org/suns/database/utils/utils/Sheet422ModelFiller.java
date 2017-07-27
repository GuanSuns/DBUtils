package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet422Config;
import org.suns.database.utils.model.Sheet422CoreModel;
import org.suns.database.utils.model.Sheet422PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet422PersonalModel sheet422PersonalModel){
        final String[] personalFieldNames = Sheet422Config.getFieldNames();

        try{
            sheet422PersonalModel.setName2(resultSet.getString(personalFieldNames[0]));
            sheet422PersonalModel.setTotalSpace2(resultSet.getFloat(personalFieldNames[1]));
            sheet422PersonalModel.setUsedOrRemainSpace2(resultSet.getFloat(personalFieldNames[2]));
            sheet422PersonalModel.setUsage2(resultSet.getFloat(personalFieldNames[3]));
            sheet422PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[4]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet422CoreModel sheet422CoreModel){

        fillPersonal(resultSet, sheet422CoreModel);
        final String[] fieldNames = Sheet422Config.getFieldNames();

        try{
            sheet422CoreModel.setName3(resultSet.getString(fieldNames[5]));
            sheet422CoreModel.setTotalSpace3(resultSet.getFloat(fieldNames[6]));
            sheet422CoreModel.setUsedOrRemainSpace3(resultSet.getFloat(fieldNames[7]));
            sheet422CoreModel.setUsage3(resultSet.getFloat(fieldNames[8]));
            sheet422CoreModel.setName4(resultSet.getString(fieldNames[9]));
            sheet422CoreModel.setTotalSpace4(resultSet.getFloat(fieldNames[10]));
            sheet422CoreModel.setUsedOrRemainSpace4(resultSet.getFloat(fieldNames[11]));
            sheet422CoreModel.setUsage4(resultSet.getFloat(fieldNames[12]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
