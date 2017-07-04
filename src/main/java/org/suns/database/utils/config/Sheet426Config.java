package org.suns.database.utils.config;

/**
 * Created by guanl on 7/4/2017.
 */

public class Sheet426Config {

    private static String personalTableName = "personal426";
    private static String coreTableName = "core426";

    private static String[] fieldNames = {"error20", "log20"
            , "error21", "log21"
            , "inspectionTime"
            , "error3", "log3"
            , "error40", "log40"
            , "error41", "log41"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " TINYINT"
            + " , " + fieldNames[1] + " LONGTEXT"
            + " , " + fieldNames[2] + " TINYINT"
            + " , " + fieldNames[3] + " LONGTEXT"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " TINYINT"
            + " , " + fieldNames[1] + " LONGTEXT"
            + " , " + fieldNames[2] + " TINYINT"
            + " , " + fieldNames[3] + " LONGTEXT"
            + " , " + fieldNames[4] + " DATETIME"
            + " , " + fieldNames[5] + " TINYINT"
            + " , " + fieldNames[6] + " LONGTEXT"
            + " , " + fieldNames[7] + " TINYINT"
            + " , " + fieldNames[8] + " LONGTEXT"
            + " , " + fieldNames[9] + " TINYINT"
            + " , " + fieldNames[10] + " LONGTEXT)";

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet426Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet426Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet426Config.fieldNames = fieldNames;
    }

    public static String getPersonalTableDefinition() {
        return "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet426Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        return "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
    }
}
