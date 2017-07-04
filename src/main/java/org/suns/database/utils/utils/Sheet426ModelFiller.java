package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426CoreModel;
import org.suns.database.utils.model.Sheet426PersonalModel;

import java.sql.ResultSet;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426ModelFiller {
    public static void fillPersonal(ResultSet resultSet, Sheet426PersonalModel sheet426PersonalModel){
        final String[] personalFieldNames = Sheet426Config.getFieldNames();

        try{
            sheet426PersonalModel.setErrorInfo2(resultSet.getInt(personalFieldNames[0]));
            sheet426PersonalModel.setLog2(resultSet.getString(personalFieldNames[1]));
            sheet426PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[2]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet426CoreModel sheet426CoreModel){

        fillPersonal(resultSet, sheet426CoreModel);
        final String[] fieldNames = Sheet426Config.getFieldNames();

        try{
            sheet426CoreModel.setErrorInfo3(resultSet.getInt(fieldNames[3]));
            sheet426CoreModel.setLog3(resultSet.getString(fieldNames[4]));
            sheet426CoreModel.setErrorInfo4(resultSet.getInt(fieldNames[5]));
            sheet426CoreModel.setLog4(resultSet.getString(fieldNames[6]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
