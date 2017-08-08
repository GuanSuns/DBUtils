package org.suns.database.utils.dao;

import org.suns.database.utils.config.DailyAppInspectionConfig;

public class DailyAppCoreDao extends AbstractDailyAppDao{
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
        return DailyAppInspectionConfig.getCoreTableName();
    }

    @Override
    protected String getTableDefinition() {
        return DailyAppInspectionConfig.getCoreTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return DailyAppInspectionConfig.getCoreSeqName();
    }

    @Override
    protected String getTriggerName() {
        return DailyAppInspectionConfig.getCoreTriggerName();
    }
}
