package org.suns.database.utills.dao;

import org.suns.database.utills.config.Sheet428Config;
import org.suns.database.utills.model.Sheet428CoreModel;
import org.suns.database.utills.utils.DBUtils;
import org.suns.database.utills.utils.Sheet428ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428CoreDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet428Config.getCoreTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet428Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet428CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 428 Core Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet428Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet428Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4]
                + ", " + fieldNames[5]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getStatus1());
        psmt.setString(2, CoreModel.getStatus2());
        psmt.setString(3, CoreModel.getStatus3());
        psmt.setString(4, CoreModel.getStatus4());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(6, CoreModel.getStatus5());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet428CoreModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet428Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet428Config.getCoreTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[4] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet428CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet428CoreModel sheet428CoreModel = new Sheet428CoreModel();
            Sheet428ModelFiller.fillCore(resultSet, sheet428CoreModel);
            resultModels.add(sheet428CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
