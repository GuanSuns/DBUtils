package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet411Config;
import org.suns.database.utils.model.Sheet411CoreModel;
import org.suns.database.utils.model.Sheet411PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet411PersonalModel sheet411PersonalModel){
        final String[] personalFiledNames = Sheet411Config.getFieldNames();

        try{
            sheet411PersonalModel.setUsage2(resultSet.getFloat(personalFiledNames[0]));
            sheet411PersonalModel.setWeblogicUsage2(resultSet.getFloat(personalFiledNames[1]));
            sheet411PersonalModel.setUsage3(resultSet.getFloat(personalFiledNames[2]));
            sheet411PersonalModel.setWeblogicUsage3(resultSet.getFloat(personalFiledNames[3]));
            sheet411PersonalModel.setUsage4(resultSet.getFloat(personalFiledNames[4]));
            sheet411PersonalModel.setWeblogicUsage4(resultSet.getFloat(personalFiledNames[5]));
            sheet411PersonalModel.setUsage5(resultSet.getFloat(personalFiledNames[6]));
            sheet411PersonalModel.setWeblogicUsage5(resultSet.getFloat(personalFiledNames[7]));
            sheet411PersonalModel.setUsage6(resultSet.getFloat(personalFiledNames[8]));
            sheet411PersonalModel.setWeblogicUsage6(resultSet.getFloat(personalFiledNames[9]));
            sheet411PersonalModel.setUsage7(resultSet.getFloat(personalFiledNames[10]));
            sheet411PersonalModel.setWeblogicUsage7(resultSet.getFloat(personalFiledNames[11]));
            sheet411PersonalModel.setDate(resultSet.getTimestamp(personalFiledNames[12]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet411CoreModel sheet411CoreModel){

        fillPersonal(resultSet, sheet411CoreModel);
        final String[] fieldNames = Sheet411Config.getFieldNames();

        try{
            sheet411CoreModel.setUsage8(resultSet.getFloat(fieldNames[13]));
            sheet411CoreModel.setWeblogicUsage8(resultSet.getFloat(fieldNames[14]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
