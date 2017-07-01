package org.suns.database.utills.utils;

import org.suns.database.utills.config.Sheet424Config;
import org.suns.database.utills.model.Sheet424CoreModel;
import org.suns.database.utills.model.Sheet424PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet424PersonalModel sheet424PersonalModel){
        final String[] personalFieldNames = Sheet424Config.getFieldNames();

        try{
            sheet424PersonalModel.setInspectTime2(resultSet.getTimestamp(personalFieldNames[0]));
            sheet424PersonalModel.setStatus2(resultSet.getString(personalFieldNames[1]));
            sheet424PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[2]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet424CoreModel sheet424CoreModel){

        fillPersonal(resultSet, sheet424CoreModel);
        final String[] fieldNames = Sheet424Config.getFieldNames();

        try{
            sheet424CoreModel.setInspectTime3(resultSet.getTimestamp(fieldNames[3]));
            sheet424CoreModel.setStatus3(resultSet.getString(fieldNames[4]));
            sheet424CoreModel.setInspectTime4(resultSet.getTimestamp(fieldNames[5]));
            sheet424CoreModel.setStatus4(resultSet.getString(fieldNames[6]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
