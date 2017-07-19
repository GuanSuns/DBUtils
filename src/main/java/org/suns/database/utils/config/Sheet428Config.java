package org.suns.database.utils.config;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428Config {

    private static String personalTableName = "PERSONAL428";
    private static String coreTableName = "CORE428";

    private static String[] fieldNames = {"status1", "status2"
            , "status3", "status4"
            , "inspectionTime"
            , "status5"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " VARCHAR(30)"
            + " , " + fieldNames[3] + " VARCHAR(30)"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " VARCHAR(30)"
            + " , " + fieldNames[3] + " VARCHAR(30)"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String oraclePersonalTableDefinition = "(id NUMBER(11) NOT NULL"
            + " , " + fieldNames[0] + " NVARCHAR2(30)"
            + " , " + fieldNames[1] + " NVARCHAR2(30)"
            + " , " + fieldNames[2] + " NVARCHAR2(30)"
            + " , " + fieldNames[3] + " NVARCHAR2(30)"
            + " , " + fieldNames[4] + " DATE)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " VARCHAR(30)"
            + " , " + fieldNames[3] + " VARCHAR(30)"
            + " , " + fieldNames[4] + " DATETIME"
            + " , " + fieldNames[5] + " VARCHAR(30))";

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " VARCHAR(30)"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " VARCHAR(30)"
            + " , " + fieldNames[3] + " VARCHAR(30)"
            + " , " + fieldNames[4] + " DATETIME"
            + " , " + fieldNames[5] + " VARCHAR(30))";

    private static String oracleCoreTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NVARCHAR2(30)"
            + " , " + fieldNames[1] + " NVARCHAR2(30)"
            + " , " + fieldNames[2] + " NVARCHAR2(30)"
            + " , " + fieldNames[3] + " NVARCHAR2(30)"
            + " , " + fieldNames[4] + " DATE"
            + " , " + fieldNames[5] + " NVARCHAR2(30))";

    private static String coreSeqName = "CORE428SEQ";
    private static String personalSeqName = "PERSONAL428SEQ";
    private static String coreTriggerName = "CORE428TRIGGER";
    private static String personalTriggerName = "PERSONAL428TRIGGER";

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
        Sheet428Config.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet428Config.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet428Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet428Config.personalTriggerName = personalTriggerName;
    }

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet428Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet428Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet428Config.fieldNames = fieldNames;
    }

    public static String getPersonalTableDefinition() {
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
        return strDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet428Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
        return strDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet428Config.coreTableDefinition = coreTableDefinition;
    }
}
