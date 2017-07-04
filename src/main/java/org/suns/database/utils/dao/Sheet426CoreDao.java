package org.suns.database.utils.dao;

import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426CoreModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.Sheet426ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet426Config.getCoreTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet426Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet426CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 426 Core Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet426Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet426Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4] + "," + fieldNames[5]
                + ", " + fieldNames[6]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, CoreModel.getErrorInfo2());
        psmt.setString(2, CoreModel.getLog2());
        psmt.setTimestamp(3, CoreModel.getDate());
        psmt.setInt(4, CoreModel.getErrorInfo3());
        psmt.setString(5, CoreModel.getLog3());
        psmt.setInt(6, CoreModel.getErrorInfo4());
        psmt.setString(7, CoreModel.getLog4());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet426CoreModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet426Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet426Config.getCoreTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[2] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet426CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet426CoreModel sheet426CoreModel = new Sheet426CoreModel();
            Sheet426ModelFiller.fillCore(resultSet, sheet426CoreModel);
            resultModels.add(sheet426CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
