package org.suns.database.utils.model;

import java.sql.Timestamp;
import java.util.Date;

public class DailyAppInspectionModel extends AbstractDataModel{
    private Timestamp inspectTime;
    private String name;
    private Float usageCPU;
    private Float usageMemory;
    private Float fileSysUsage;
    private int svrState;
    private Float hoggingCount;
    private int dataSourceState;
    private Float dataSourceConnectionCount;

    public DailyAppInspectionModel() {
        this.inspectTime = new Timestamp(new Date().getTime());
        this.name = "";
        this.usageCPU = 0f;
        this.usageMemory = 0f;
        this.fileSysUsage = 0f;
        this.svrState = 0;
        this.hoggingCount = 0f;
        this.dataSourceState = 0;
        this.dataSourceConnectionCount = 0f;
    }

    public Timestamp getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Timestamp inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUsageCPU() {
        return usageCPU;
    }

    public void setUsageCPU(Float usageCPU) {
        this.usageCPU = usageCPU;
    }

    public Float getUsageMemory() {
        return usageMemory;
    }

    public void setUsageMemory(Float usageMemory) {
        this.usageMemory = usageMemory;
    }

    public Float getFileSysUsage() {
        return fileSysUsage;
    }

    public void setFileSysUsage(Float fileSysUsage) {
        this.fileSysUsage = fileSysUsage;
    }

    public int getSvrState() {
        return svrState;
    }

    public void setSvrState(int svrState) {
        this.svrState = svrState;
    }

    public Float getHoggingCount() {
        return hoggingCount;
    }

    public void setHoggingCount(Float hoggingCount) {
        this.hoggingCount = hoggingCount;
    }

    public int getDataSourceState() {
        return dataSourceState;
    }

    public void setDataSourceState(int dataSourceState) {
        this.dataSourceState = dataSourceState;
    }

    public Float getDataSourceConnectionCount() {
        return dataSourceConnectionCount;
    }

    public void setDataSourceConnectionCount(Float dataSourceConnectionCount) {
        this.dataSourceConnectionCount = dataSourceConnectionCount;
    }

    @Override
    public String toString() {
        return "DailyAppInspectionModel{" +
                "inspectTime=" + inspectTime +
                ", name='" + name + '\'' +
                ", usageCPU=" + usageCPU +
                ", usageMemory=" + usageMemory +
                ", fileSysUsage=" + fileSysUsage +
                ", svrState=" + svrState +
                ", hoggingCount=" + hoggingCount +
                ", dataSourceState=" + dataSourceState +
                ", dataSourceConnectionCount=" + dataSourceConnectionCount +
                '}';
    }
}
