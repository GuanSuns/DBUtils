package org.suns.database.utils.dao;

import org.suns.database.utils.config.DailyDBInspectionConfig;

public class DailyDBCoreDao extends AbstractDailyDBDao{
    private static boolean tableExisted = false;
    private static boolean sequenceAndTriggerExisted = false;

    @Override
    public void setTableExist(boolean isExist) {
        tableExisted = isExist;
    }

    @Override
    public void setSequenceAndTriggerExisted(boolean isExist) {
        sequenceAndTriggerExisted = isExist;
    }

    @Override
    public boolean isTableExist() {
        return tableExisted;
    }

    @Override
    public boolean isSequenceAndTriggerExisted() {
        return sequenceAndTriggerExisted;
    }

    @Override
    protected String getTableName() {
        return DailyDBInspectionConfig.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return DailyDBInspectionConfig.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return DailyDBInspectionConfig.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return DailyDBInspectionConfig.getCoreTriggerName();
    }
}
