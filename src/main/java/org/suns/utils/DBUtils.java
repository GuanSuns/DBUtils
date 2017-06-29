package org.suns.utils;

import org.suns.config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by guanl on 6/28/2017.
 */
public class DBUtils {
    private static Connection connection = null;

    private static void initConnection() throws Exception{
        Class.forName(DBConfig.getDriver());
        connection = DriverManager.getConnection(DBConfig.getUrl()
                , DBConfig.getName(), DBConfig.getPassword());
    }

    public static Connection getConnection() throws Exception{
        if(connection == null){
            initConnection();
        }
        return connection;
    }

    public static void closeConnection() throws Exception{
        if(connection != null){
            connection.close();
            connection = null;
        }
    }
}

