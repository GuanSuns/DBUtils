package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreModel extends Sheet423PersonalModel {
    private String name3;
    private Float totalSpace3;
    private Float remainSpace3;
    private Float usage3;

    private String name4;
    private Float totalSpace4;
    private Float remainSpace4;
    private Float usage4;

    public Sheet423CoreModel() {
        super();

        this.name3 = "";
        this.totalSpace3 = 0f;
        this.remainSpace3 = 0f;
        this.usage3 = 0F;

        this.name4 = "";
        this.totalSpace4 = 0f;
        this.remainSpace4 = 0f;
        this.usage4 = 0f;
    }

    public Sheet423CoreModel(Timestamp date, String asmName2
            , Float totalSpace2, Float remainSpace2
            , Float usage2, String name3, Float totalSpace3
            , Float remainSpace3, Float usage3, String name4
            , Float totalSpace4, Float remainSpace4, Float usage4) {
        super(date, asmName2, totalSpace2, remainSpace2, usage2);
        this.name3 = name3;
        this.totalSpace3 = totalSpace3;
        this.remainSpace3 = remainSpace3;
        this.usage3 = usage3;
        this.name4 = name4;
        this.totalSpace4 = totalSpace4;
        this.remainSpace4 = remainSpace4;
        this.usage4 = usage4;
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
        return remainSpace3;
    }

    @Override
    public void setUsedOrRemainSpace3(Float usedOrRemainSpace) {
        this.remainSpace3 = usedOrRemainSpace;
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
        return remainSpace4;
    }

    @Override
    public void setUsedOrRemainSpace4(Float usedOrRemainSpace) {
        this.remainSpace4 = usedOrRemainSpace;
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
        return "Sheet423CoreModel{" +
                "date=" + date +
                ", name3='" + name3 +
                ", totalSpace3=" + totalSpace3 +
                ", remainSpace3=" + remainSpace3 +
                ", usage3=" + usage3 +
                ", name4='" + name4 +
                ", totalSpace4=" + totalSpace4 +
                ", remainSpace4=" + remainSpace4 +
                ", usage4=" + usage4 +
                '}';
    }
}
