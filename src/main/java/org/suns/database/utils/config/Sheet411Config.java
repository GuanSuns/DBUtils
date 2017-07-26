package org.suns.database.utils.config;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411Config {
    private static String personalTableName = "PERSONAL411";
    private static String coreTableName = "CORE411";

    private static String[] fieldNames = {"usage2", "weblogicUsage2"
            , "usage3", "weblogicUsage3"
            , "usage4", "weblogicUsage4"
            , "usage5", "weblogicUsage5"
            , "usage6", "weblogicUsage6"
            , "usage7", "weblogicUsage7"
            , "inspectionTime", "usage8", "weblogicUsage8"
    };

    private static final int timeFieldIndex = 12;

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

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
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

    private static String oraclePersonalTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
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
            + " , " + fieldNames[12] + " DATE)";

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

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
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

    private static String oracleCoreTableDefinition = "(id NUMBER(38) NOT NULL PRIMARY KEY"
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
            + " , " + fieldNames[12] + " DATE"
            + " , " + fieldNames[13] + " NUMERIC(38,2)"
            + " , " + fieldNames[14] + " NUMERIC(38,2))";

    private static String coreSeqName = "CORE411SEQ";
    private static String personalSeqName = "PERSONAL411SEQ";
    private static String coreTriggerName = "CORE411TRIGGER";
    private static String personalTriggerName = "PERSONAL411TRIGGER";

    public static int getTimeFieldIndex() {
        return timeFieldIndex;
    }

    public static void setConfigToMySQL(){
        coreTableDefinition = mysqlCoreTableDefinition;
        personalTableDefinition = mysqlPersonalTableDefinition;
    }

    public static void setConfigToOracle(){
        coreTableDefinition = oracleCoreTableDefinition;
        personalTableDefinition = oraclePersonalTableDefinition;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet411Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet411Config.personalTriggerName = personalTriggerName;
    }

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

    public static String getCoreSeqName() {
        return coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
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

    public static void setCoreSeqName(String coreSeqName) {
        Sheet411Config.coreSeqName = coreSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet411Config.personalSeqName = personalSeqName;
    }
}
