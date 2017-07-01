package org.suns.database.utils.dao;

import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.model.Sheet421PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.Sheet421ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet421Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet421Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet421PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 421 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet421Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet421Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, personalModel.getUsage2());
        psmt.setFloat(2, personalModel.getU01Usage2());
        psmt.setFloat(3, personalModel.getGoldUsage2());
        psmt.setFloat(4, personalModel.getUsage3());
        psmt.setFloat(5, personalModel.getU01Usage3());
        psmt.setTimestamp(6, personalModel.getDate());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet421PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
                tableExisted = true;

                DBUtils.closeConnection();
                return null;
            }
            tableExisted = true;
        }

        final String[] fieldNames = Sheet421Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet421Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[5] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet421PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet421PersonalModel sheet421PersonalModel = new Sheet421PersonalModel();
            Sheet421ModelFiller.fillPersonal(resultSet, sheet421PersonalModel);
            resultModels.add(sheet421PersonalModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
