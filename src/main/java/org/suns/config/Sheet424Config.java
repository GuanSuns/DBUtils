package org.suns.config;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424Config {
    private static String personalTableName = "personal424";
    private static String coreTableName = "core424";

    private static String[] fieldNames = {"collectTime2", "status2", "inspectionTime"
            , "collectTime3", "status3"
            , "collectTime4", "status4"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " DATETIME"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30))";

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet424Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet424Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet424Config.fieldNames = fieldNames;
    }

    public static String getPersonalTableDefinition() {
        return personalTableDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet424Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        return coreTableDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet424Config.coreTableDefinition = coreTableDefinition;
    }
}
