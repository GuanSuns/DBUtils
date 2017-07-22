package org.suns.database.utils.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class MySQLUtils {
    public static boolean checkTableExisted(Connection connection, String tableName) throws Exception{
        if(connection == null || tableName == null || tableName.equals("")){
            throw new Exception("Uninitialized Argument");
        }

        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null
                , tableName, null);

        boolean result = false;
        if(resultSet.next()){
            result = true;
        }

        return result;
    }

    public void abortRecentInstances(int minutes, String tableName
            , String timeFiledName) throws Exception{

    }
}
