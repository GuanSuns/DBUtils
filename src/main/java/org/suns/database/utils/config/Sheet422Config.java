package org.suns.database.utils.config;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422Config {
    private static String personalTableName = "personal422";
    private static String coreTableName = "core422";

    private static String[] fieldNames = {"tsName2", "totalSpace2", "usedSpace2"
            , "usage2", "inspectionTime"
            , "tsName3", "totalSpace3", "usedSpace3", "usage3"
            , "tsName4", "totalSpace4", "usedSpace4", "usage4"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " DATETIME"
            + " , " + fieldNames[5] + " VARCHAR(30)"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " VARCHAR(30)"
            + " , " + fieldNames[10] + " NUMERIC(38,2)"
            + " , " + fieldNames[11] + " NUMERIC(38,2)"
            + " , " + fieldNames[12] + " NUMERIC(38,2))";


    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet422Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet422Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet422Config.fieldNames = fieldNames;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet422Config.personalTableDefinition = personalTableDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet422Config.coreTableDefinition = coreTableDefinition;
    }

    public static String getPersonalTableDefinition() {
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
        return strDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
        return strDefinition;
    }
}
