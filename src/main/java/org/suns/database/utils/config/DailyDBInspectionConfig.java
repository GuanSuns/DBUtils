package org.suns.database.utils.config;


public class DailyDBInspectionConfig {
    private static String personalTableName = "DAILYPERSONALDB";
    private static String coreTableName = "DAILYCOREDB";

    private static String[] fieldNames = {"inspectionTime", "name"
            , "usageCPU", "usageMemory", "usageArchiveSpace", "hasLongTermLock"
            , "hasOverloadTableSpace", "hasErrorInLog"
            , "diskBusy", "hasOggError", "hasOggDelay"
    };

    private static final int timeFieldIndex = 0;

    private static String tableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " TINYINT"
            + " , " + fieldNames[6] + " TINYINT"
            + " , " + fieldNames[7] + " TINYINT"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " TINYINT"
            + " , " + fieldNames[10] + " TINYINT)";

    private static String mysqlTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " DATETIME"
            + " , " + fieldNames[1] + " VARCHAR(30)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " TINYINT"
            + " , " + fieldNames[6] + " TINYINT"
            + " , " + fieldNames[7] + " TINYINT"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " TINYINT"
            + " , " + fieldNames[10] + " TINYINT)";

    private static String oracleTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " DATE"
            + " , " + fieldNames[1] + " NVARCHAR2(30)"
            + " , " + fieldNames[2] + " NUMERIC(38,2)"
            + " , " + fieldNames[3] + " NUMERIC(38,2)"
            + " , " + fieldNames[4] + " NUMERIC(38,2)"
            + " , " + fieldNames[5] + " NUMBER"
            + " , " + fieldNames[6] + " NUMBER"
            + " , " + fieldNames[7] + " NUMBER"
            + " , " + fieldNames[8] + " NUMERIC(38,2)"
            + " , " + fieldNames[9] + " NUMBER"
            + " , " + fieldNames[10] + " NUMBER)";

    private static String coreSeqName = "COREDAILYDBSEQ";
    private static String personalSeqName = "PERSONALDAILYDBSEQ";
    private static String coreTriggerName = "COREDAILYDBTRIGGER";
    private static String personalTriggerName = "PERSONALDAILYDBTRIGGER";

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
        DailyDBInspectionConfig.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        DailyDBInspectionConfig.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        DailyDBInspectionConfig.fieldNames = fieldNames;
    }

    public static int getTimeFieldIndex() {
        return timeFieldIndex;
    }

    public static String getCoreSeqName() {
        return coreSeqName;
    }

    public static void setCoreSeqName(String coreSeqName) {
        DailyDBInspectionConfig.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        DailyDBInspectionConfig.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        DailyDBInspectionConfig.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        DailyDBInspectionConfig.personalTriggerName = personalTriggerName;
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
