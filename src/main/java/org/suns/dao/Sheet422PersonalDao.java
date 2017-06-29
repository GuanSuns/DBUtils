package org.suns.dao;

import org.suns.config.Sheet422Config;
import org.suns.model.Sheet422PersonalModel;
import org.suns.utils.DBUtils;
import org.suns.utils.Sheet422ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet422Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet422Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet422PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 422 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet422Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet422Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getTsName2());
        psmt.setFloat(2, personalModel.getTsTotalSpace2());
        psmt.setFloat(3, personalModel.getTsUsedSpace2());
        psmt.setFloat(4, personalModel.getTsUsage2());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet422PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet422Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet422Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[4] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet422PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet422PersonalModel sheet422PersonalModel = new Sheet422PersonalModel();
            Sheet422ModelFiller.fillPersonal(resultSet, sheet422PersonalModel);
            resultModels.add(sheet422PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
