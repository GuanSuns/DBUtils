package org.suns.utils;

import org.suns.config.Sheet423Config;
import org.suns.model.Sheet423CoreModel;
import org.suns.model.Sheet423PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet423PersonalModel sheet423PersonalModel){
        final String[] personalFieldNames = Sheet423Config.getFieldNames();

        try{
            sheet423PersonalModel.setAsmName2(resultSet.getString(personalFieldNames[0]));
            sheet423PersonalModel.setTotalSpace2(resultSet.getInt(personalFieldNames[1]));
            sheet423PersonalModel.setRemainSpace2(resultSet.getInt(personalFieldNames[2]));
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
            sheet423CoreModel.setAsmName3(resultSet.getString(fieldNames[5]));
            sheet423CoreModel.setTotalSpace3(resultSet.getInt(fieldNames[6]));
            sheet423CoreModel.setRemainSpace3(resultSet.getInt(fieldNames[7]));
            sheet423CoreModel.setUsage3(resultSet.getFloat(fieldNames[8]));
            sheet423CoreModel.setAsmName4(resultSet.getString(fieldNames[9]));
            sheet423CoreModel.setTotalSpace4(resultSet.getInt(fieldNames[10]));
            sheet423CoreModel.setRemainSpace4(resultSet.getInt(fieldNames[11]));
            sheet423CoreModel.setUsage4(resultSet.getFloat(fieldNames[12]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
