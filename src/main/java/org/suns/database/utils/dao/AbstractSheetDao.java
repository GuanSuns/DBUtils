package org.suns.database.utils.dao;

import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;
import org.suns.database.utils.config.Sheet411Config;
import org.suns.database.utils.utils.DBUtils;
import org.suns.database.utils.utils.MySQLUtils;
import org.suns.database.utils.utils.OracleUtils;
import org.suns.inspection.logger.InspectionLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractSheetDao {

    protected abstract String getTableName();
    protected abstract String getTableDefinition();
    protected abstract void setTableExist(boolean isExist);
    protected abstract void setSequenceAndTriggerExisted(boolean isExist);
    protected abstract boolean isTableExist();
    protected abstract boolean isSequenceAndTriggerExisted();
    protected abstract String getSeqName();
    protected abstract String getTriggerName();
    protected abstract String[] getFieldNames();
    protected abstract int getTimeFieldIndex();

    public void abortRecentInstances(int minutes) throws Exception{
        //Invalid argument
        if(minutes < 0) return;

        Connection connection = DBUtils.getConnection();
        preCheck(connection);

        String[] fieldNames = getFieldNames();
        deleteRecentInstances(connection, minutes
                , fieldNames[getTimeFieldIndex()], getTableName());

        DBUtils.closeConnection();
    }


    void checkSequenceAndTriggerExisted(Connection connection
            , boolean resetSeq) throws Exception{
        if(!OracleUtils.checkSeqExisted(connection, getSeqName())){
            OracleUtils.createSeq(connection, getSeqName());
        }else if(resetSeq){
            OracleUtils.dropSeq(connection, getSeqName());
            OracleUtils.createSeq(connection, getSeqName());
        }

        OracleUtils.createOrReplaceTrigger(connection
                , getTriggerName()
                , getTableName()
                , getSeqName()
                , "id");
    }

    void createTable(Connection connection) throws Exception{
        Statement statement = connection.createStatement();
        String sql = getTableDefinition();
        statement.executeUpdate(sql);
    }

    boolean checkTableExist(Connection connection) throws Exception{
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            return MySQLUtils.checkTableExisted(connection, getTableName());
        }else{
            return OracleUtils.checkTableExisted(connection, getTableName());
        }
    }

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
            , int days) throws Exception{
        String sql;

        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "SELECT * FROM " + getTableName()
                    + " WHERE DATE_SUB(CURDATE(), INTERVAL " + days
                    + " DAY) <= DATE(" + getFieldNames()[getTimeFieldIndex()] + ")"
                    + " ORDER BY ID ASC";
        }else{
            sql = "SELECT * FROM " + getTableName()
                    + " WHERE " + getFieldNames()[getTimeFieldIndex()]
                    + ">SYSDATE-" + days
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

    public void clearAll() throws Exception{
        Connection connection = DBUtils.getConnection();
        String sql = "";
        if(DBConfig.getDbType().equals(DBType.mySQL)){
            sql = "DROP TABLE " + getTableName() + "IF EXISTS";
        }else if(DBConfig.getDbType().equals(DBType.oracle)){
            sql = "BEGIN EXECUTE IMMEDIATE 'DROP TABLE "
                    + getTableName() + "';" +
                    "EXCEPTION WHEN OTHERS THEN NULL;" +
                    "END;";
        }

        InspectionLogger.debug("Dropping table - " + sql);

        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}
