package org.suns.database.utils.config;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428Config {

    private static String personalTableName = "personal428";
    private static String coreTableName = "core428";

    private static String[] fieldNames = {"status1", "status2"
            , "status3", "status4"
            , "inspectionTime"
            , "status5"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " VARCHAR(30)"
            + " , " + fieldNames[3] + " VARCHAR(30)"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " VARCHAR(30)"
            + " , " + fieldNames[3] + " VARCHAR(30)"
            + " , " + fieldNames[4] + " DATETIME"
            + " , " + fieldNames[5] + " VARCHAR(30))";

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet428Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet428Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet428Config.fieldNames = fieldNames;
    }

    public static String getPersonalTableDefinition() {
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
        return strDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet428Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
        return strDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet428Config.coreTableDefinition = coreTableDefinition;
    }
}
