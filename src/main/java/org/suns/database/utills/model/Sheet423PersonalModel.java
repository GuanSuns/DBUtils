package org.suns.database.utills.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalModel {
    protected Timestamp date;
    private String asmName2;
    private Integer totalSpace2;
    private Integer remainSpace2;
    private Float usage2;

    public Sheet423PersonalModel() {
        this.date = null;
        this.asmName2 = "";
        this.totalSpace2 = 0;
        this.remainSpace2 = 0;
        this.usage2 = 0F;
    }

    public Sheet423PersonalModel(Timestamp date, String asmName2
            , Integer totalSpace2, Integer remainSpace2, Float usage2) {
        this.date = date;
        this.asmName2 = asmName2;
        this.totalSpace2 = totalSpace2;
        this.remainSpace2 = remainSpace2;
        this.usage2 = usage2;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAsmName2() {
        return asmName2;
    }

    public void setAsmName2(String asmName2) {
        this.asmName2 = asmName2;
    }

    public Integer getTotalSpace2() {
        return totalSpace2;
    }

    public void setTotalSpace2(Integer totalSpace2) {
        this.totalSpace2 = totalSpace2;
    }

    public Integer getRemainSpace2() {
        return remainSpace2;
    }

    public void setRemainSpace2(Integer remainSpace2) {
        this.remainSpace2 = remainSpace2;
    }

    public Float getUsage2() {
        return usage2;
    }

    public void setUsage2(Float usage2) {
        this.usage2 = usage2;
    }

    @Override
    public String toString() {
        return "Sheet423PersonalModel{" +
                "date=" + date +
                ", asmName2='" + asmName2 +
                ", totalSpace2=" + totalSpace2 +
                ", remainSpace2=" + remainSpace2 +
                ", usage2=" + usage2 +
                '}';
    }
}
