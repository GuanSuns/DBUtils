package org.suns.database.utils.config;

public class DailyAppInspectionConfig {
    private static String personalTableName = "DAILYPERSONALAPP";
    private static String coreTableName = "DAILYCOREAPP";

    private static String[] fieldNames = {"inspectionTime", "name"
            , "usageCPU", "usageMemory", "fileSysUsage"
            , "svrState", "hoggingCount"
            , "dataSourceState", "dataSourceConnectionCount"
    };

    private static final int timeFieldIndex = 0;

    private static String tableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + "  TINYINT"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + "  TINYINT"
            + " , " + fieldNames[8] + " NUMERIC(38,2))";

    private static String mysqlTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " TINYINT"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " TINYINT"
            + " , " + fieldNames[8] + " NUMERIC(38,2))";

    private static String oracleTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " DATE"
            + " , " + fieldNames[1] + " NVARCHAR2(30)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " NUMBER"
            + " , " + fieldNames[6] + " NUMERIC(38,2)"
            + " , " + fieldNames[7] + " NUMBER"
            + " , " + fieldNames[8] + " NUMERIC(38,2))";

    private static String coreSeqName = "COREDAILYAPPSEQ";
    private static String personalSeqName = "PERSONALDAILYAPPSEQ";
    private static String coreTriggerName = "COREDAILYAPPTRIGGER";
    private static String personalTriggerName = "PERSONALDAILYAPPTRIGGER";

    public static int getTimeFieldIndex() {
        return timeFieldIndex;
    }

    public static void setConfigToMySQL(){
        tableDefinition = mysqlTableDefinition;
    }

    public static void setConfigToOracle(){
        tableDefinition = oracleTableDefinition;
    }

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        DailyAppInspectionConfig.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        DailyAppInspectionConfig.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        DailyAppInspectionConfig.fieldNames = fieldNames;
    }

    public static String getMysqlTableDefinition() {
        return mysqlTableDefinition;
    }

    public static void setMysqlTableDefinition(String mysqlTableDefinition) {
        DailyAppInspectionConfig.mysqlTableDefinition = mysqlTableDefinition;
    }

    public static String getOracleTableDefinition() {
        return oracleTableDefinition;
    }

    public static void setOracleTableDefinition(String oracleTableDefinition) {
        DailyAppInspectionConfig.oracleTableDefinition = oracleTableDefinition;
    }

    public static String getCoreSeqName() {
        return coreSeqName;
    }

    public static void setCoreSeqName(String coreSeqName) {
        DailyAppInspectionConfig.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        DailyAppInspectionConfig.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        DailyAppInspectionConfig.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        DailyAppInspectionConfig.personalTriggerName = personalTriggerName;
    }

    public static String getPersonalTableDefinition() {
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + tableDefinition;
        return strDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + tableDefinition;
        return strDefinition;
    }
}
