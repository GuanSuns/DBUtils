package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet429Config;
import org.suns.database.utils.model.Sheet429CoreModel;
import org.suns.database.utils.model.Sheet429PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet429PersonalModel sheet429PersonalModel){
        final String[] personalFieldNames = Sheet429Config.getFieldNames();

        try{
            sheet429PersonalModel.setHeartBeat1(resultSet.getString(personalFieldNames[0]));
            sheet429PersonalModel.setInspectTime(resultSet.getTimestamp(personalFieldNames[1]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet429CoreModel sheet429CoreModel){

        fillPersonal(resultSet, sheet429CoreModel);
        final String[] fieldNames = Sheet429Config.getFieldNames();

        try{
            sheet429CoreModel.setHeartBeat2(resultSet.getString(fieldNames[2]));
            sheet429CoreModel.setHeartBeat3(resultSet.getString(fieldNames[3]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
