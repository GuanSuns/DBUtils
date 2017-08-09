package org.suns.database.utils.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class DBConfig {
    private static String driver =  "oracle.jdbc.driver.OracleDriver";
    //Mysql Driver: com.mysql.cj.jdbc.Driver , Oracle Driver: oracle.jdbc.driver.OracleDriver
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    //Mysql Test Url: jdbc:mysql://localhost:3306/test_jdbc?useUnicode=true&haracterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8
    //Oracle Test Url: jdbc:oracle:thin:@localhost:1521:XE
    private static String name = "root_jdbc";
    //Mysql Test Name: root , Oracle Test Name: root_jdbc
    private static String password = "guanlin25";

    private static DBType dbType = DBType.oracle;

    private static int defaultNumericNullValue = -1;

    public static void setConfigToOracle(){
        dbType = DBType.oracle;
        Sheet411Config.setConfigToOracle();
        Sheet421Config.setConfigToOracle();
        Sheet422Config.setConfigToOracle();
        Sheet423Config.setConfigToOracle();
        Sheet424Config.setConfigToOracle();
        Sheet426Config.setConfigToOracle();
        Sheet428Config.setConfigToOracle();
        Sheet429Config.setConfigToOracle();
        DailyAppInspectionConfig.setConfigToOracle();
        DailyDBInspectionConfig.setConfigToOracle();
    }

    public static void setConfigToMySQL(){
        dbType = DBType.mySQL;
        Sheet411Config.setConfigToMySQL();
        Sheet421Config.setConfigToMySQL();
        Sheet422Config.setConfigToMySQL();
        Sheet423Config.setConfigToMySQL();
        Sheet424Config.setConfigToMySQL();
        Sheet426Config.setConfigToMySQL();
        Sheet428Config.setConfigToMySQL();
        Sheet429Config.setConfigToMySQL();
        DailyAppInspectionConfig.setConfigToMySQL();
        DailyDBInspectionConfig.setConfigToMySQL();
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
