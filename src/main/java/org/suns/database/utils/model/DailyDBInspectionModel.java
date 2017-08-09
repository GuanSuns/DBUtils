package org.suns.database.utils.model;

import java.sql.Timestamp;
import java.util.Date;

public class DailyDBInspectionModel extends AbstractDataModel{
    private Timestamp inspectTime;
    private String name;
    private Float usageCPU;
    private Float usageMemory;
    private Float usageArchiveSpace;
    private int hasLongTermLock;
    private int hasOverloadTableSpace;
    private int hasErrorInLog;
    private Float diskBusy;
    private int hasOggError;
    private int hasOggDelay;

    public DailyDBInspectionModel() {
        this.inspectTime = new Timestamp(new Date().getTime());
        this.name = "";
        this.usageCPU = 0f;
        this.usageMemory = 0f;
        this.usageArchiveSpace = 0f;
        this.hasLongTermLock = 0;
        this.hasOverloadTableSpace = 0;
        this.hasErrorInLog = 0;
        this.diskBusy = 0f;
        this.hasOggDelay = 0;
        this.hasOggError = 0;
    }

    public Float getUsageArchiveSpace() {
        return usageArchiveSpace;
    }

    public void setUsageArchiveSpace(Float usageArchiveSpace) {
        this.usageArchiveSpace = usageArchiveSpace;
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

    public int getHasLongTermLock() {
        return hasLongTermLock;
    }

    public void setHasLongTermLock(int hasLongTermLock) {
        this.hasLongTermLock = hasLongTermLock;
    }

    public int getHasOverloadTableSpace() {
        return hasOverloadTableSpace;
    }

    public void setHasOverloadTableSpace(int hasOverloadTableSpace) {
        this.hasOverloadTableSpace = hasOverloadTableSpace;
    }

    public int getHasErrorInLog() {
        return hasErrorInLog;
    }

    public void setHasErrorInLog(int hasErrorInLog) {
        this.hasErrorInLog = hasErrorInLog;
    }

    public Float getDiskBusy() {
        return diskBusy;
    }

    public void setDiskBusy(Float diskBusy) {
        this.diskBusy = diskBusy;
    }

    public int getHasOggError() {
        return hasOggError;
    }

    public void setHasOggError(int hasOggError) {
        this.hasOggError = hasOggError;
    }

    public int getHasOggDelay() {
        return hasOggDelay;
    }

    public void setHasOggDelay(int hasOggDelay) {
        this.hasOggDelay = hasOggDelay;
    }

    @Override
    public String toString() {
        return "DailyDBInspectionModel{" +
                "inspectTime=" + inspectTime +
                ", name='" + name + '\'' +
                ", usageCPU=" + usageCPU +
                ", usageMemory=" + usageMemory +
                ", usageArchiveSpace=" + usageArchiveSpace +
                ", hasLongTermLock=" + hasLongTermLock +
                ", hasOverloadTableSpace=" + hasOverloadTableSpace +
                ", hasErrorInLog=" + hasErrorInLog +
                ", diskBusy=" + diskBusy +
                ", hasOggError=" + hasOggError +
                ", hasOggDelay=" + hasOggDelay +
                "} ";
    }
}
