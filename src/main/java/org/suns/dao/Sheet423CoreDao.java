package org.suns.dao;

import org.suns.config.Sheet423Config;
import org.suns.model.Sheet423CoreModel;
import org.suns.utils.DBUtils;
import org.suns.utils.Sheet423ModelFiller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreDao {
    private static boolean tableExisted = false;

    private static boolean checkTableExist(Connection connection) throws Exception{
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , Sheet423Config.getCoreTableName(), null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    private static void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = Sheet423Config.getCoreTableDefinition();
        statement.executeUpdate(sql);
    }

    public static void addInstance(Sheet423CoreModel CoreModel) throws Exception{
        if(CoreModel == null){
            throw new Exception("Uninitialized Sheet 423 Core Model");
        }

        Connection connection = DBUtils.getConnection();

        if(!tableExisted){
            if(!checkTableExist(connection)){
                createTable(connection);
            }
            tableExisted = true;
        }

        String[] fieldNames = Sheet423Config.getFieldNames();

        String sql = "INSERT INTO " + Sheet423Config.getCoreTableName()
                + " (" + fieldNames[0] + "," + fieldNames[1]
                + "," + fieldNames[2] + "," + fieldNames[3]
                + "," + fieldNames[4] + "," + fieldNames[5]
                + "," + fieldNames[6] + "," + fieldNames[7]
                + "," + fieldNames[8] + "," + fieldNames[9]
                + "," + fieldNames[10] + "," + fieldNames[11]
                + "," + fieldNames[12]
                + ", id) " + "VALUES("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setString(1, CoreModel.getAsmName2());
        psmt.setFloat(2, CoreModel.getTotalSpace2());
        psmt.setFloat(3, CoreModel.getRemainSpace2());
        psmt.setFloat(4, CoreModel.getUsage2());
        psmt.setTimestamp(5, CoreModel.getDate());
        psmt.setString(1, CoreModel.getAsmName3());
        psmt.setFloat(2, CoreModel.getTotalSpace3());
        psmt.setFloat(3, CoreModel.getRemainSpace3());
        psmt.setFloat(4, CoreModel.getUsage3());
        psmt.setString(1, CoreModel.getAsmName4());
        psmt.setFloat(2, CoreModel.getTotalSpace4());
        psmt.setFloat(3, CoreModel.getRemainSpace4());
        psmt.setFloat(4, CoreModel.getUsage4());

        psmt.execute();

        DBUtils.closeConnection();
    }

    public static ArrayList<Sheet423CoreModel> getRecentInstances(int days) throws Exception{
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

        String sql = "SELECT * FROM " + Sheet423Config.getCoreTableName()
                + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                + " DAY) <= DATE(" + fieldNames[4] + ")";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Sheet423CoreModel> resultModels = new ArrayList<>();
        while(resultSet.next()){
            Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel();
            Sheet423ModelFiller.fillCore(resultSet, sheet423CoreModel);
            resultModels.add(sheet423CoreModel);
        }

        DBUtils.closeConnection();

        return resultModels;
    }
}
