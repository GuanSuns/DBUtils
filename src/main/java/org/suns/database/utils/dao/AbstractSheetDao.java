package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractSheetDao {

    protected abstract boolean checkTableExist(Connection connection) throws Exception;
    protected abstract void createTable(Connection connection) throws Exception;
    protected abstract void setTableExist(boolean isExist);
    protected abstract void setSequenceAndTriggerExisted(boolean isExist);
    protected abstract boolean isTableExist();
    protected abstract boolean isSequenceAndTriggerExisted();
    protected abstract void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception;

    void preCheck(Connection connection) throws Exception{
        if(connection == null){
            throw new Exception("Invalid Connection");
        }

        boolean dropSeqFlag = false;

        if(!isTableExist()){
            if(!checkTableExist(connection)){
                createTable(connection);
                dropSeqFlag = true;
            }
            setTableExist(true);
        }
        if(!isSequenceAndTriggerExisted() && DBConfig.getDbType().equals(DBType.oracle)){
            checkSequenceAndTriggerExisted(connection, dropSeqFlag);
            setSequenceAndTriggerExisted(true);
        }
    }

    ResultSet selectRecentInstances(Connection connection
            , int days, String timeFiled, String tableName) throws Exception{
        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + tableName
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + timeFiled + ")"
                    + " ORDER BY ID ASC";
        }else{
            sql = "SELECT * FROM " + tableName
                    + " WHERE " + timeFiled + ">SYSDATE-" + days
                    + " ORDER BY ID ASC";
        }

        Statement stmt = connection.createStatement();
        return stmt.executeQuery(sql);
    }

    void deleteRecentInstances(Connection connection
            , int minutes, String timeField, String tableName) throws Exception{
        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "DELETE FROM " + tableName
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + minutes
                    + " MINUTE) <= DATE(" + timeField + ")";
        }else{
            sql = "DELETE FROM " + tableName
                    + " WHERE " + timeField + ">SYSDATE-" + minutes
                    + "/(60*24)";
        }

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }
}
