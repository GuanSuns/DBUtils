package org.suns.database.utills.dao;

import org.suns.database.utills.config.Sheet423Config;
import org.suns.database.utills.model.Sheet423PersonalModel;
import org.suns.database.utills.utils.DBUtils;
import org.suns.database.utills.utils.Sheet423ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet423Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet423Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet423PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 423 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet423Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet423Config.getPersonalTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, personalModel.getAsmName2());
        psmt.setFloat(2, personalModel.getTotalSpace2());
        psmt.setFloat(3, personalModel.getRemainSpace2());
        psmt.setFloat(4, personalModel.getUsage2());
        psmt.setTimestamp(5, personalModel.getDate());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet423PersonalModel> getRecentInstances(int days) throws Exception{
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

        final String[] fieldNames = Sheet423Config.getFieldNames();

        String sql = "SELECT * FROM " + Sheet423Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[4] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet423PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet423PersonalModel sheet423PersonalModel = new Sheet423PersonalModel();
            Sheet423ModelFiller.fillPersonal(resultSet, sheet423PersonalModel);
            resultModels.add(sheet423PersonalModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
