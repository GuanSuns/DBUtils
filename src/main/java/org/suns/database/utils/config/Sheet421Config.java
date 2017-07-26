package org.suns.database.utils.config;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421Config {
    private static String personalTableName = "PERSONAL421";
    private static String coreTableName = "CORE421";

    private static String[] fieldNames = {"usage2", "u01Usage2", "goldUsage2"
            , "usage3", "u01Usage3"
            , "inspectionTime"
            , "usage4", "u01Usage4", "goldUsage4"
            , "usage5", "u01Usage5"
    };

    private static final int timeFieldIndex = 5;

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " DATETIME)";

    private static String oraclePersonalTableDefinition = "(id NUMBER(38) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " DATE)";

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " DATETIME"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NUMERIC(38,2)"
            + " , " + fieldNames[10] + " NUMERIC(38,2))";

    private static String oracleCoreTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " DATE"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NUMERIC(38,2)"
            + " , " + fieldNames[10] + " NUMERIC(38,2))";

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " NUMERIC(38,2)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " DATETIME"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NUMERIC(38,2)"
            + " , " + fieldNames[10] + " NUMERIC(38,2))";

    private static String coreSeqName = "CORE421SEQ";
    private static String personalSeqName = "PERSONAL421SEQ";
    private static String coreTriggerName = "CORE421TRIGGER";
    private static String personalTriggerName = "PERSONAL421TRIGGER";

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

    public static String getCoreSeqName() {
        return coreSeqName;
    }

    public static void setCoreSeqName(String coreSeqName) {
        Sheet421Config.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet421Config.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet421Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet421Config.personalTriggerName = personalTriggerName;
    }

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet421Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet421Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet421Config.fieldNames = fieldNames;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet421Config.personalTableDefinition = personalTableDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet421Config.coreTableDefinition = coreTableDefinition;
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
