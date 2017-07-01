package org.suns.database.utils.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411Config {
    private static String personalTableName = "personal411";
    private static String coreTableName = "core411";

    private static String[] fieldNames = {"usage2", "weblogicUsage2"
            , "usage3", "weblogicUsage3"
            , "usage4", "weblogicUsage4"
            , "usage5", "weblogicUsage5"
            , "usage6", "weblogicUsage6"
            , "usage7", "weblogicUsage7"
            , "inspectionTime", "usage8", "weblogicUsage8"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " NUMERIC(38,2)"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NUMERIC(38,2)"
            + " , " + fieldNames[10] + " NUMERIC(38,2)"
            + " , " + fieldNames[11] + " NUMERIC(38,2)"
            + " , " + fieldNames[12] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " NUMERIC(38,2)"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NUMERIC(38,2)"
            + " , " + fieldNames[10] + " NUMERIC(38,2)"
            + " , " + fieldNames[11] + " NUMERIC(38,2)"
            + " , " + fieldNames[12] + " DATETIME"
            + " , " + fieldNames[13] + " NUMERIC(38,2)"
            + " , " + fieldNames[14] + " NUMERIC(38,2))";


    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
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

    public static void setPersonalTableName(String personalTableName) {
        Sheet411Config.personalTableName = personalTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet411Config.coreTableName = coreTableName;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet411Config.fieldNames = fieldNames;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet411Config.personalTableDefinition = personalTableDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet411Config.coreTableDefinition = coreTableDefinition;
    }
}
