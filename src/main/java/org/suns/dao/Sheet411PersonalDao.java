package org.suns.dao;

import org.suns.config.Sheet411Config;
import org.suns.model.Sheet411PersonalModel;
import org.suns.utils.DBUtils;
import org.suns.utils.Sheet411ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411PersonalDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet411Config.getPersonalTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet411Config.getPersonalTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet411PersonalModel personalModel) throws Exception{
        if(personalModel == null){
            throw new Exception("Uninitialized Sheet 411 Personal Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] personalFiledNames = Sheet411Config.getFiledNames();

        String sql = "INSERT INTO " + Sheet411Config.getPersonalTableName()
                + " (" + personalFiledNames[0] + "," + personalFiledNames[1]
                + "," + personalFiledNames[2] + "," + personalFiledNames[3]
                + "," + personalFiledNames[4] + "," + personalFiledNames[5]
                + "," + personalFiledNames[6] + "," + personalFiledNames[7]
                + "," + personalFiledNames[8] + "," + personalFiledNames[9]
                + "," + personalFiledNames[10] + "," + personalFiledNames[11]
                + "," + personalFiledNames[12] + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setFloat(1, personalModel.getUsage2());
        psmt.setFloat(2, personalModel.getWeblogicUsage2());
        psmt.setFloat(3, personalModel.getUsage3());
        psmt.setFloat(4, personalModel.getWeblogicUsage3());
        psmt.setFloat(5, personalModel.getUsage4());
        psmt.setFloat(6, personalModel.getWeblogicUsage4());
        psmt.setFloat(7, personalModel.getUsage5());
        psmt.setFloat(8, personalModel.getWeblogicUsage5());
        psmt.setFloat(9, personalModel.getUsage6());
        psmt.setFloat(10, personalModel.getWeblogicUsage6());
        psmt.setFloat(11, personalModel.getUsage7());
        psmt.setFloat(12, personalModel.getWeblogicUsage7());
        psmt.setTimestamp(13, personalModel.getDate());

        psmt.execute();
    }

    public static ArrayList<Sheet411PersonalModel> getRecentInstances(int days) throws Exception{
        //Invalid argument
        if(days < 0) return null;

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                System.out.println("Create Table");
                createTable(connection);
                tableExisted = true;
                return null;
            }
            tableExisted = true;
        }

        String[] personalFiledNames = Sheet411Config.getFiledNames();

        String sql = "SELECT * FROM " + Sheet411Config.getPersonalTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + personalFiledNames[12] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet411PersonalModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet411PersonalModel sheet411PersonalModel = new Sheet411PersonalModel();
            Sheet411ModelFiller.fillPersonal(resultSet, sheet411PersonalModel);
            resultModels.add(sheet411PersonalModel);
        }

        return resultModels;
    }
}
