package org.suns.database.utils.dao;

import org.suns.database.utils.config.Sheet428Config;
import org.suns.database.utils.model.Sheet428PersonalModel;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.Sheet428ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet428Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet428Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet428PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 428 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet428Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet428Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + ", " + fieldNames[2] + "," + fieldNames[3]
                + ", " + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getStatus1());
        psmt.setString(2, personalModel.getStatus2());
        psmt.setString(3, personalModel.getStatus3());
        psmt.setString(4, personalModel.getStatus4());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet428PersonalModel> getRecentInstances(int days) throws Exception{
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

        String sql = "SELECT * FROM " + Sheet428Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[4] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet428PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet428PersonalModel sheet428PersonalModel = new Sheet428PersonalModel();
            Sheet428ModelFiller.fillPersonal(resultSet, sheet428PersonalModel);
            resultModels.add(sheet428PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
