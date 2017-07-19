package org.suns.database.utils.config;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422Config {
    private static String personalTableName = "PERSONAL422";
    private static String coreTableName = "CORE422";

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

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String oraclePersonalTableDefinition = "(id NUMBER(38) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NVARCHAR2(30)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " DATE)";

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

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
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

    private static String oracleCoreTableDefinition = "(id NUMBER(38) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NVARCHAR2(30)"
            + " , " + fieldNames[1] + " NUMERIC(38,2)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " DATE"
            + " , " + fieldNames[5] + " NVARCHAR2(30)"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMERIC(38,2)"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NVARCHAR2(30)"
            + " , " + fieldNames[10] + " NUMERIC(38,2)"
            + " , " + fieldNames[11] + " NUMERIC(38,2)"
            + " , " + fieldNames[12] + " NUMERIC(38,2))";

    private static String coreSeqName = "CORE422SEQ";
    private static String personalSeqName = "PERSONAL422SEQ";
    private static String coreTriggerName = "CORE422TRIGGER";
    private static String personalTriggerName = "PERSONAL422TRIGGER";

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
        Sheet422Config.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet422Config.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet422Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet422Config.personalTriggerName = personalTriggerName;
    }

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
