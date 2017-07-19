package org.suns.database.utils.config;

/**
 * Created by guanl on 7/4/2017.
 */

public class Sheet426Config {

    private static String personalTableName = "PERSONAL426";
    private static String coreTableName = "CORE426";

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

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " TINYINT"
            + " , " + fieldNames[1] + " LONGTEXT"
            + " , " + fieldNames[2] + " TINYINT"
            + " , " + fieldNames[3] + " LONGTEXT"
            + " , " + fieldNames[4] + " DATETIME)";

    private static String oraclePersonalTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NUMBER"
            + " , " + fieldNames[1] + " NVARCHAR2(2000)"
            + " , " + fieldNames[2] + " NUMBER"
            + " , " + fieldNames[3] + " NVARCHAR2(2000)"
            + " , " + fieldNames[4] + " DATE)";

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

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
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

    private static String oracleCoreTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " NUMBER"
            + " , " + fieldNames[1] + " NVARCHAR2(2000)"
            + " , " + fieldNames[2] + " NUMBER"
            + " , " + fieldNames[3] + " NVARCHAR2(2000)"
            + " , " + fieldNames[4] + " DATE"
            + " , " + fieldNames[5] + " NUMBER"
            + " , " + fieldNames[6] + " NVARCHAR2(2000)"
            + " , " + fieldNames[7] + " NUMBER"
            + " , " + fieldNames[8] + " NVARCHAR2(2000)"
            + " , " + fieldNames[9] + " NUMBER"
            + " , " + fieldNames[10] + " NVARCHAR2(2000))";

    private static String coreSeqName = "CORE426SEQ";
    private static String personalSeqName = "PERSONAL426SEQ";
    private static String coreTriggerName = "CORE426TRIGGER";
    private static String personalTriggerName = "PERSONAL426TRIGGER";

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
        Sheet426Config.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet426Config.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet426Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet426Config.personalTriggerName = personalTriggerName;
    }

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
