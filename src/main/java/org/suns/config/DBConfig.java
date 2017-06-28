package org.suns.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class DBConfig {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test_jdbc" +
            "?useUnicode=true" +
            "&characterEncoding=UTF-8" +
            "&useSSL=false" +
            "&serverTimezone=GMT%2B8";
    private static String name = "root";
    private static String password = "guanlin25";

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
}
