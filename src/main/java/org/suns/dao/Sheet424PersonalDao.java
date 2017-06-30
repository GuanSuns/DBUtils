package org.suns.dao;

import org.suns.config.Sheet424Config;
import org.suns.model.Sheet424PersonalModel;
import org.suns.utils.DBUtils;
import org.suns.utils.Sheet424ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet424Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet424Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet424PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 424 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet424Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet424Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2]
                + ", id) " + "VALUES("
                + "?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setTimestamp(1, personalModel.getInspectTime2());
        psmt.setString(2, personalModel.getStatus2());
        psmt.setTimestamp(3, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet424PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet424Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet424Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[2] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet424PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet424PersonalModel sheet424PersonalModel = new Sheet424PersonalModel();
            Sheet424ModelFiller.fillPersonal(resultSet, sheet424PersonalModel);
            resultModels.add(sheet424PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
