package org.suns.database.utils.dao;

import org.suns.database.utils.config.DailyDBInspectionConfig;

public class DailyDBPersonalDao extends AbstractDailyDBDao{
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
        return DailyDBInspectionConfig.getPersonalTableName();
    }

    @Override
    protected String getTableDefinition() {
        return DailyDBInspectionConfig.getPersonalTableDefinition();
    }

    @Override
    protected String getSeqName() {
        return DailyDBInspectionConfig.getPersonalSeqName();
    }

    @Override
    protected String getTriggerName() {
        return DailyDBInspectionConfig.getPersonalTriggerName();
    }
}
