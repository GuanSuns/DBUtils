package org.suns.database.utills.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalModel {
    protected Timestamp date;

    protected String tsName2;
    protected Float tsTotalSpace2;
    protected Float tsUsedSpace2;
    protected Float tsUsage2;

    public Sheet422PersonalModel() {
        this.date = null;
        this.tsName2 = "";
        this.tsTotalSpace2 = 0f;
        this.tsUsedSpace2 = 0f;
        this.tsUsage2 = 0f;
    }

    public Sheet422PersonalModel(Timestamp date, String tsName2
            , Float tsTotalSpace2, Float tsUsedSpace2, Float tsUsage2) {
        this.date = date;
        this.tsName2 = tsName2;
        this.tsTotalSpace2 = tsTotalSpace2;
        this.tsUsedSpace2 = tsUsedSpace2;
        this.tsUsage2 = tsUsage2;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getTsName2() {
        return tsName2;
    }

    public void setTsName2(String tsName2) {
        this.tsName2 = tsName2;
    }

    public Float getTsTotalSpace2() {
        return tsTotalSpace2;
    }

    public void setTsTotalSpace2(Float tsTotalSpace2) {
        this.tsTotalSpace2 = tsTotalSpace2;
    }

    public Float getTsUsedSpace2() {
        return tsUsedSpace2;
    }

    public void setTsUsedSpace2(Float tsUsedSpace2) {
        this.tsUsedSpace2 = tsUsedSpace2;
    }

    public Float getTsUsage2() {
        return tsUsage2;
    }

    public void setTsUsage2(Float tsUsage2) {
        this.tsUsage2 = tsUsage2;
    }

    @Override
    public String toString() {
        return "Sheet422PersonalModel{" +
                "date=" + date +
                ", tsName2='" + tsName2 +
                ", tsTotalSpace2=" + tsTotalSpace2 +
                ", tsUsedSpace2=" + tsUsedSpace2 +
                ", tsUsage2=" + tsUsage2 +
                '}';
    }
}
