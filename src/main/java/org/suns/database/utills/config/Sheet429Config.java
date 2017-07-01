package org.suns.database.utills.config;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429Config {
    private static String personalTableName = "personal429";
    private static String coreTableName = "core429";

    private static String[] fieldNames = {"heartBeat1"
            , "inspectionTime"
            , "heartBeat2", "heartBeat3"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " LONGTEXT"
            + " , " + fieldNames[1] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " LONGTEXT"
            + " , " + fieldNames[1] + " DATETIME"
            + " , " + fieldNames[2] + " LONGTEXT"
            + " , " + fieldNames[3] + " LONGTEXT";

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet429Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet429Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet429Config.fieldNames = fieldNames;
    }

    public static String getPersonalTableDefinition() {
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
        return strDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet429Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
        return strDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet429Config.coreTableDefinition = coreTableDefinition;
    }
}
