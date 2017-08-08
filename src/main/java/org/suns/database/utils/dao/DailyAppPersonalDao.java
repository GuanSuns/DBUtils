package org.suns.database.utils.dao;

import org.suns.database.utils.config.DailyAppInspectionConfig;

public class DailyAppPersonalDao extends AbstractDailyAppDao{
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
        return DailyAppInspectionConfig.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return DailyAppInspectionConfig.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return DailyAppInspectionConfig.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return DailyAppInspectionConfig.getPersonalTriggerName();
    }
}
