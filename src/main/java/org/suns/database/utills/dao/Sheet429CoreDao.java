package org.suns.database.utills.dao;

import org.suns.database.utills.config.Sheet429Config;
import org.suns.database.utills.model.Sheet429CoreModel;
import org.suns.database.utills.utils.DBUtils;
import org.suns.database.utills.utils.Sheet429ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet429Config.getCoreTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet429Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet429CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 429 Core Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet429Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet429Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + ", id) " + "VALUES("
                + "?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getHeartBeat1());
        psmt.setTimestamp(2, CoreModel.getInspectTime());
        psmt.setString(3, CoreModel.getHeartBeat2());
        psmt.setString(4, CoreModel.getHeartBeat3());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet429CoreModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet429Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet429Config.getCoreTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[1] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet429CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet429CoreModel sheet429CoreModel = new Sheet429CoreModel();
            Sheet429ModelFiller.fillCore(resultSet, sheet429CoreModel);
            resultModels.add(sheet429CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
