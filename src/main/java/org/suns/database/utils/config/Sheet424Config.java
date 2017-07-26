package org.suns.database.utils.config;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424Config {
    private static String personalTableName = "PERSONAL424";
    private static String coreTableName = "CORE424";

    private static String[] fieldNames = {"collectTime2", "status2", "inspectionTime"
            , "collectTime3", "status3"
            , "collectTime4", "status4"
    };

    private static final int timeFieldIndex = 2;

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " DATETIME)";

    private static String oraclePersonalTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " DATE"
            + " , " + fieldNames[1] + " NVARCHAR2(30)"
            + " , " + fieldNames[2] + " DATE)";

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " DATETIME)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " DATETIME"
            + " , " + fieldNames[3] + " DATETIME"
            + " , " + fieldNames[4] + " VARCHAR(30)"
            + " , " + fieldNames[5] + " DATETIME"
            + " , " + fieldNames[6] + " VARCHAR(30))";

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " DATETIME"
            + " , " + fieldNames[3] + " DATETIME"
            + " , " + fieldNames[4] + " VARCHAR(30)"
            + " , " + fieldNames[5] + " DATETIME"
            + " , " + fieldNames[6] + " VARCHAR(30))";

    private static String oracleCoreTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " DATE"
            + " , " + fieldNames[1] + " NVARCHAR2(30)"
            + " , " + fieldNames[2] + " DATE"
            + " , " + fieldNames[3] + " DATE"
            + " , " + fieldNames[4] + " NVARCHAR2(30)"
            + " , " + fieldNames[5] + " DATE"
            + " , " + fieldNames[6] + " NVARCHAR2(30))";

    private static String coreSeqName = "CORE424SEQ";
    private static String personalSeqName = "PERSONAL424SEQ";
    private static String coreTriggerName = "CORE424TRIGGER";
    private static String personalTriggerName = "PERSONAL424TRIGGER";

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
        Sheet424Config.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet424Config.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet424Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet424Config.personalTriggerName = personalTriggerName;
    }

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
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
        return strDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet424Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
        return strDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet424Config.coreTableDefinition = coreTableDefinition;
    }
}
