package org.suns.database.utils.dao;

import org.suns.database.utils.config.Sheet426Config;
import org.suns.database.utils.model.Sheet426PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.Sheet426ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet426Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet426Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet426PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 426 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet426Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet426Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2]
                + ", id) " + "VALUES("
                + "?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, personalModel.getErrorInfo2());
        psmt.setString(2, personalModel.getLog2());
        psmt.setTimestamp(3, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet426PersonalModel> getRecentInstances(int days) throws Exception{
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

        String sql = "SELECT * FROM " + Sheet426Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[2] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet426PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet426PersonalModel sheet426PersonalModel = new Sheet426PersonalModel();
            Sheet426ModelFiller.fillPersonal(resultSet, sheet426PersonalModel);
            resultModels.add(sheet426PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
