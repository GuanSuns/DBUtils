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
            sheet426PersonalModel.setErrorInfo20(resultSet.getInt(personalFieldNames[0]));
            sheet426PersonalModel.setLog20(resultSet.getString(personalFieldNames[1]));
            sheet426PersonalModel.setErrorInfo21(resultSet.getInt(personalFieldNames[2]));
            sheet426PersonalModel.setLog21(resultSet.getString(personalFieldNames[3]));
            sheet426PersonalModel.setDate(resultSet.getTimestamp(personalFieldNames[4]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillCore(ResultSet resultSet, Sheet426CoreModel sheet426CoreModel){

        fillPersonal(resultSet, sheet426CoreModel);
        final String[] fieldNames = Sheet426Config.getFieldNames();

        try{
            sheet426CoreModel.setErrorInfo3(resultSet.getInt(fieldNames[5]));
            sheet426CoreModel.setLog3(resultSet.getString(fieldNames[6]));
            sheet426CoreModel.setErrorInfo40(resultSet.getInt(fieldNames[7]));
            sheet426CoreModel.setLog40(resultSet.getString(fieldNames[8]));
            sheet426CoreModel.setErrorInfo41(resultSet.getInt(fieldNames[9]));
            sheet426CoreModel.setLog41(resultSet.getString(fieldNames[10]));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
