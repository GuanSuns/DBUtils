package org.suns.database.utils.utils;

import org.suns.database.utils.config.Sheet411Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by guanl on 7/18/2017.
 */
public class OracleUtils {
    public static boolean checkSeqExisted(Connection connection
            , String seqName) throws Exception{
        if(connection == null || seqName == null || seqName.equals("")){
            throw new Exception("Uninitialized arguments");
        }

        String sql = "SELECT COUNT(*) CNT FROM USER_SEQUENCES " +
                "WHERE SEQUENCE_NAME='" + seqName + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        resultSet.next();
        int cnt = resultSet.getInt("CNT");

        if(cnt > 0){
            return true;
        }else{
            return false;
        }
    }

    public static void createSeq(Connection connection, String seqName) throws Exception{
        Statement statement = connection.createStatement();
        String sql = "CREATE SEQUENCE " + seqName + " MINVALUE 0 " +
                "NOMAXVALUE START WITH 0 " +
                "INCREMENT BY 1 NOCYCLE NOCACHE";
        statement.executeUpdate(sql);
    }

    public static void dropSeq(Connection connection, String seqName) throws Exception{
        Statement statement = connection.createStatement();
        String sql = "DROP SEQUENCE " + seqName;
        statement.execute(sql);
    }

    public static void createOrReplaceTrigger(Connection connection
            , String triggerName, String tableName
            , String seqName, String idKey) throws Exception{
        if(connection == null || triggerName == null || triggerName.equals("")
                || tableName == null || tableName.equals("")
                || seqName == null || seqName.equals("")
                || idKey == null || idKey.equals("")){
            throw new Exception("Uninitialized arguments");
        }

        String sql = "CREATE OR REPLACE TRIGGER "
                + triggerName +" BEFORE INSERT ON "
                + tableName + " FOR EACH ROW "
                + "begin select " + seqName + ".nextval into:new."
                + idKey + " from dual; end;";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public static boolean checkTableExisted(Connection connection
            , String tableName) throws Exception{
        if(connection == null || tableName == null || tableName.equals("")){
            throw new Exception("Uninitialized Argument");
        }

        String sql = "SELECT COUNT(*) CNT FROM USER_TABLES " +
                "WHERE TABLE_NAME='" + tableName + "'";

        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        resultSet.next();
        int cnt = resultSet.getInt("CNT");

        if(cnt > 0){
            return true;
        }else{
            return false;
        }
    }
}
