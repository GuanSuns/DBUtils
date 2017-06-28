package org.suns.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411Config {
    private static String personalTableName = "personal411";
    private static String coreTableName = "core411";

    private static String[] filedNames = {"usage2", "weblogicUsage2"
            , "usage3", "weblogicUsage3"
            , "usage4", "weblogicUsage4"
            , "usage5", "weblogicUsage5"
            , "usage6", "weblogicUsage6"
            , "usage7", "weblogicUsage7"
            , "inspectionTime", "usage8", "weblogicUsage8"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + filedNames[0] + " NUMERIC(38,2)"
            + " , " + filedNames[1] + " NUMERIC(38,2)"
            + " , " + filedNames[2] + " NUMERIC(38,2)"
            + " , " + filedNames[3] + " NUMERIC(38,2)"
            + " , " + filedNames[4] + " NUMERIC(38,2)"
            + " , " + filedNames[5] + " NUMERIC(38,2)"
            + " , " + filedNames[6] + " NUMERIC(38,2)"
            + " , " + filedNames[7] + " NUMERIC(38,2)"
            + " , " + filedNames[8] + " NUMERIC(38,2)"
            + " , " + filedNames[9] + " NUMERIC(38,2)"
            + " , " + filedNames[10] + " NUMERIC(38,2)"
            + " , " + filedNames[11] + " NUMERIC(38,2)"
            + " , " + filedNames[12] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + filedNames[0] + " NUMERIC(38,2)"
            + " , " + filedNames[1] + " NUMERIC(38,2)"
            + " , " + filedNames[2] + " NUMERIC(38,2)"
            + " , " + filedNames[3] + " NUMERIC(38,2)"
            + " , " + filedNames[4] + " NUMERIC(38,2)"
            + " , " + filedNames[5] + " NUMERIC(38,2)"
            + " , " + filedNames[6] + " NUMERIC(38,2)"
            + " , " + filedNames[7] + " NUMERIC(38,2)"
            + " , " + filedNames[8] + " NUMERIC(38,2)"
            + " , " + filedNames[9] + " NUMERIC(38,2)"
            + " , " + filedNames[10] + " NUMERIC(38,2)"
            + " , " + filedNames[11] + " NUMERIC(38,2)"
            + " , " + filedNames[12] + " DATETIME"
            + " , " + filedNames[13] + " NUMERIC(38,2)"
            + " , " + filedNames[14] + " NUMERIC(38,2))";


    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static String[] getFiledNames() {
        return filedNames;
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

    public static void setFiledNames(String[] filedNames) {
        Sheet411Config.filedNames = filedNames;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet411Config.personalTableDefinition = personalTableDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet411Config.coreTableDefinition = coreTableDefinition;
    }
}
