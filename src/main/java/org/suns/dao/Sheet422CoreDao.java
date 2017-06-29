package org.suns.dao;

import org.suns.config.Sheet422Config;
import org.suns.model.Sheet422CoreModel;
import org.suns.utils.DBUtils;
import org.suns.utils.Sheet422ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422CoreDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet422Config.getCoreTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet422Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet422CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 422 Core Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet422Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet422Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + "," + fieldNames[5] + "," + fieldNames[6]
                + "," + fieldNames[7] + "," + fieldNames[8]
                + "," + fieldNames[9] + "," + fieldNames[10]
                + "," + fieldNames[11] + "," + fieldNames[12]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getTsName2());
        psmt.setFloat(2, CoreModel.getTsTotalSpace2());
        psmt.setFloat(3, CoreModel.getTsUsedSpace2());
        psmt.setFloat(4, CoreModel.getTsUsage2());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(6, CoreModel.getTsName3());
        psmt.setFloat(7, CoreModel.getTsTotalSpace3());
        psmt.setFloat(8, CoreModel.getTsUsedSpace3());
        psmt.setFloat(9, CoreModel.getTsUsage3());
        psmt.setString(10, CoreModel.getTsName4());
        psmt.setFloat(11, CoreModel.getTsTotalSpace4());
        psmt.setFloat(12, CoreModel.getTsUsedSpace4());
        psmt.setFloat(13, CoreModel.getTsUsage4());

        psmt.execute();
        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet422CoreModel> getRecentInstances(int days) throws Exception{
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

        String sql = "SELECT * FROM " + Sheet422Config.getCoreTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[4] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet422CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet422CoreModel sheet422CoreModel = new Sheet422CoreModel();
            Sheet422ModelFiller.fillCore(resultSet, sheet422CoreModel);
            resultModels.add(sheet422CoreModel);
        }

        DBUtils.closeConnection();
        return resultModels;
    }
}
