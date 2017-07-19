package org.suns.database.utils.config;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429Config {
    private static String personalTableName = "PERSONAL429";
    private static String coreTableName = "CORE429";

    private static String[] fieldNames = {"heartBeat1"
            , "inspectionTime"
            , "heartBeat2", "heartBeat3"
    };

    private static String personalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " LONGTEXT"
            + " , " + fieldNames[1] + " DATETIME)";

    private static String mysqlPersonalTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " LONGTEXT"
            + " , " + fieldNames[1] + " DATETIME)";

    private static String oraclePersonalTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " LONG"
            + " , " + fieldNames[1] + " DATE)";

    private static String coreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " LONGTEXT"
            + " , " + fieldNames[1] + " DATETIME"
            + " , " + fieldNames[2] + " LONGTEXT"
            + " , " + fieldNames[3] + " LONGTEXT)";

    private static String mysqlCoreTableDefinition = "(id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT"
            + " , " + fieldNames[0] + " LONGTEXT"
            + " , " + fieldNames[1] + " DATETIME"
            + " , " + fieldNames[2] + " LONGTEXT"
            + " , " + fieldNames[3] + " LONGTEXT)";

    private static String oracleCoreTableDefinition = "(id NUMBER(11) NOT NULL PRIMARY KEY"
            + " , " + fieldNames[0] + " LONG"
            + " , " + fieldNames[1] + " DATE"
            + " , " + fieldNames[2] + " LONG"
            + " , " + fieldNames[3] + " LONG)";

    private static String coreSeqName = "CORE429SEQ";
    private static String personalSeqName = "PERSONAL429SEQ";
    private static String coreTriggerName = "CORE429TRIGGER";
    private static String personalTriggerName = "PERSONAL429TRIGGER";

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
        Sheet429Config.coreSeqName = coreSeqName;
    }

    public static String getPersonalSeqName() {
        return personalSeqName;
    }

    public static void setPersonalSeqName(String personalSeqName) {
        Sheet429Config.personalSeqName = personalSeqName;
    }

    public static String getCoreTriggerName() {
        return coreTriggerName;
    }

    public static void setCoreTriggerName(String coreTriggerName) {
        Sheet429Config.coreTriggerName = coreTriggerName;
    }

    public static String getPersonalTriggerName() {
        return personalTriggerName;
    }

    public static void setPersonalTriggerName(String personalTriggerName) {
        Sheet429Config.personalTriggerName = personalTriggerName;
    }

    public static String getPersonalTableName() {
        return personalTableName;
    }

    public static void setPersonalTableName(String personalTableName) {
        Sheet429Config.personalTableName = personalTableName;
    }

    public static String getCoreTableName() {
        return coreTableName;
    }

    public static void setCoreTableName(String coreTableName) {
        Sheet429Config.coreTableName = coreTableName;
    }

    public static String[] getFieldNames() {
        return fieldNames;
    }

    public static void setFieldNames(String[] fieldNames) {
        Sheet429Config.fieldNames = fieldNames;
    }

    public static String getPersonalTableDefinition() {
        String strDefinition = "CREATE TABLE " + personalTableName
                + " " + personalTableDefinition;
        return strDefinition;
    }

    public static void setPersonalTableDefinition(String personalTableDefinition) {
        Sheet429Config.personalTableDefinition = personalTableDefinition;
    }

    public static String getCoreTableDefinition() {
        String strDefinition = "CREATE TABLE " + coreTableName
                + " " + coreTableDefinition;
        return strDefinition;
    }

    public static void setCoreTableDefinition(String coreTableDefinition) {
        Sheet429Config.coreTableDefinition = coreTableDefinition;
    }
}
