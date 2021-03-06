package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.database.utils.model.Sheet421PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet421PersonalModel sheet421PersonalModel){
        final String[] personalFieldNames = Sheet421Config.getFieldNames();

        try{
            sheet421PersonalModel.setUsage2(resultSet.getFloat(personalFieldNames[0]));
            sheet421PersonalModel.setU01Usage2(resultSet.getFloat(personalFieldNames[1]));
            sheet421PersonalModel.setGoldUsage2(resultSet.getFloat(personalFieldNames[2]));
            sheet421PersonalModel.setUsage3(resultSet.getFloat(personalFieldNames[3]));
            sheet421PersonalModel.setU01Usage3(resultSet.getFloat(personalFieldNames[4]));
            sheet421PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[5]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet421CoreModel sheet421CoreModel){

        fillPersonal(resultSet, sheet421CoreModel);
        final String[] fieldNames = Sheet421Config.getFieldNames();

        try{
            sheet421CoreModel.setUsage4(resultSet.getFloat(fieldNames[6]));
            sheet421CoreModel.setU01Usage4(resultSet.getFloat(fieldNames[7]));
            sheet421CoreModel.setGoldUsage4(resultSet.getFloat(fieldNames[8]));
            sheet421CoreModel.setUsage5(resultSet.getFloat(fieldNames[9]));
            sheet421CoreModel.setU01Usage5(resultSet.getFloat(fieldNames[10]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
