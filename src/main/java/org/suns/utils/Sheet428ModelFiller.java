package org.suns.utils;

import org.suns.config.Sheet428Config;
import org.suns.model.Sheet428CoreModel;
import org.suns.model.Sheet428PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet428PersonalModel sheet428PersonalModel){
        final String[] personalFieldNames = Sheet428Config.getFieldNames();

        try{
            sheet428PersonalModel.setStatus1(resultSet.getString(personalFieldNames[0]));
            sheet428PersonalModel.setStatus2(resultSet.getString(personalFieldNames[1]));
            sheet428PersonalModel.setStatus3(resultSet.getString(personalFieldNames[2]));
            sheet428PersonalModel.setStatus4(resultSet.getString(personalFieldNames[3]));
            sheet428PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[4]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet428CoreModel sheet428CoreModel){

        fillPersonal(resultSet, sheet428CoreModel);
        final String[] fieldNames = Sheet428Config.getFieldNames();

        try{
            sheet428CoreModel.setStatus5(resultSet.getString(fieldNames[5]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
