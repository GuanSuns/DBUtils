package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422CoreModel extends Sheet422PersonalModel {

    private String name3;
    private Float totalSpace3;
    private Float usedSpace3;
    private Float usage3;

    private String name4;
    private Float totalSpace4;
    private Float usedSpace4;
    private Float usage4;

    public Sheet422CoreModel() {
        super();
        this.name3 = "";
        this.totalSpace3 = 0f;
        this.usedSpace3 = 0f;
        this.usage3 = 0f;

        this.name4 = "";
        this.totalSpace4 = 0f;
        this.usedSpace4 = 0f;
        this.usage4 = 0f;
    }

    public Sheet422CoreModel(Timestamp date, String tsName2
            , Float tsTotalSpace2, Float tsUsedSpace2
            , Float tsUsage2, String tsName3, Float tsTotalSpace3
            , Float tsUsedSpace3, Float tsUsage3, String tsName4, Float tsTotalSpace4
            , Float tsUsedSpace4, Float tsUsage4) {
        super(date, tsName2, tsTotalSpace2, tsUsedSpace2, tsUsage2);
        this.name3 = tsName3;
        this.totalSpace3 = tsTotalSpace3;
        this.usedSpace3 = tsUsedSpace3;
        this.usage3 = tsUsage3;
        this.name4 = tsName4;
        this.totalSpace4 = tsTotalSpace4;
        this.usedSpace4 = tsUsedSpace4;
        this.usage4 = tsUsage4;
    }

    @Override
    public String getName3() {
        return name3;
    }

    @Override
    public void setName3(String name) {
        this.name3 = name;
    }

    @Override
    public Float getTotalSpace3() {
        return totalSpace3;
    }

    @Override
    public void setTotalSpace3(Float totalSpace) {
        this.totalSpace3 = totalSpace;
    }

    @Override
    public Float getUsedOrRemainSpace3() {
        return usedSpace3;
    }

    @Override
    public void setUsedOrRemainSpace3(Float usedOrRemainSpace) {
        this.usedSpace3 = usedOrRemainSpace;
    }

    @Override
    public Float getUsage3() {
        return usage3;
    }

    @Override
    public void setUsage3(Float usage) {
        this.usage3 = usage;
    }

    @Override
    public String getName4() {
        return name4;
    }

    @Override
    public void setName4(String name) {
        this.name4 = name;
    }

    @Override
    public Float getTotalSpace4() {
        return totalSpace4;
    }

    @Override
    public void setTotalSpace4(Float totalSpace) {
        this.totalSpace4 = totalSpace;
    }

    @Override
    public Float getUsedOrRemainSpace4() {
        return usedSpace4;
    }

    @Override
    public void setUsedOrRemainSpace4(Float usedOrRemainSpace) {
        this.usedSpace4 = usedOrRemainSpace;
    }

    @Override
    public Float getUsage4() {
        return usage4;
    }

    @Override
    public void setUsage4(Float usage) {
        this.usage4 = usage;
    }

    @Override
    public String toString() {
        return "Sheet422CoreModel{" +
                "date=" + date +
                ", tsName3='" + name3 +
                ", tsName2='" + name2 +
                ", tsTotalSpace3=" + totalSpace3 +
                ", tsTotalSpace2=" + totalSpace2 +
                ", tsUsedSpace3=" + usedSpace3 +
                ", tsUsedSpace2=" + usedSpace2 +
                ", tsUsage3=" + usage3 +
                ", tsUsage2=" + usage2 +
                ", tsName4='" + name4 +
                ", tsTotalSpace4=" + totalSpace4 +
                ", tsUsedSpace4=" + usedSpace4 +
                ", tsUsage4=" + usage4 +
                '}';
    }
}
