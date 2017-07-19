package org.suns.database.utils.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class DBConfig {
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String name = "root_jdbc";
    private static String password = "guanlin25";

    private static DBType dbType = DBType.oracle;

    private static int defaultNumericNullValue = -1;

    public static void setConfigToOracle(){
        Sheet411Config.setConfigToOracle();
        Sheet421Config.setConfigToOracle();
        Sheet422Config.setConfigToOracle();
    }

    public static void setConfigToMySQL(){
        Sheet411Config.setConfigToMySQL();
        Sheet421Config.setConfigToMySQL();
        Sheet421Config.setConfigToMySQL();
    }

    public static void setDefaultNumericNullValue(int defaultNumericNullValue) {
        DBConfig.defaultNumericNullValue = defaultNumericNullValue;
    }

    public static void setDriver(String driver) {
        DBConfig.driver = driver;
    }

    public static void setUrl(String url) {
        DBConfig.url = url;
    }

    public static void setName(String name) {
        DBConfig.name = name;
    }

    public static void setPassword(String password) {
        DBConfig.password = password;
    }

    public static DBType getDbType() {
        return dbType;
    }

    public static void setDbType(DBType dbType) {
        DBConfig.dbType = dbType;
    }

    public static String getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }

    public static int getDefaultNumericNullValue() {
        return defaultNumericNullValue;
    }
}
