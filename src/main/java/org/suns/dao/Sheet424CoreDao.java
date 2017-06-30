package org.suns.dao;

import org.suns.config.Sheet424Config;
import org.suns.model.Sheet424CoreModel;
import org.suns.utils.DBUtils;
import org.suns.utils.Sheet424ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424CoreDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet424Config.getCoreTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet424Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet424CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 424 Core Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet424Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet424Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2]
                + "," + fieldNames[3] + "," + fieldNames[4]
                + "," + fieldNames[5] + "," + fieldNames[6]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setTimestamp(1, CoreModel.getInspectTime2());
        psmt.setString(2, CoreModel.getStatus2());
        psmt.setTimestamp(3, CoreModel.getDate());
        psmt.setTimestamp(4, CoreModel.getInspectTime3());
        psmt.setString(5, CoreModel.getStatus3());
        psmt.setTimestamp(6, CoreModel.getInspectTime4());
        psmt.setString(7, CoreModel.getStatus4());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet424CoreModel> getRecentInstances(int days) throws Exception{
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

        String sql = "SELECT * FROM " + Sheet424Config.getCoreTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[2] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet424CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet424CoreModel sheet424CoreModel = new Sheet424CoreModel();
            Sheet424ModelFiller.fillCore(resultSet, sheet424CoreModel);
            resultModels.add(sheet424CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
