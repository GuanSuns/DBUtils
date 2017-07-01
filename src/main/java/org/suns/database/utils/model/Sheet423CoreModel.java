package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423CoreModel extends Sheet423PersonalModel {
    private String asmName3;
    private Integer totalSpace3;
    private Integer remainSpace3;
    private Float usage3;

    private String asmName4;
    private Integer totalSpace4;
    private Integer remainSpace4;
    private Float usage4;

    public Sheet423CoreModel() {
        super();

        this.asmName3 = "";
        this.totalSpace3 = 0;
        this.remainSpace3 = 0;
        this.usage3 = 0F;

        this.asmName4 = "";
        this.totalSpace4 = 0;
        this.remainSpace4 = 0;
        this.usage4 = 0f;
    }

    public Sheet423CoreModel(Timestamp date, String asmName2
            , Integer totalSpace2, Integer remainSpace2
            , Float usage2, String asmName3, Integer totalSpace3
            , Integer remainSpace3, Float usage3, String asmName4
            , Integer totalSpace4, Integer remainSpace4, Float usage4) {
        super(date, asmName2, totalSpace2, remainSpace2, usage2);
        this.asmName3 = asmName3;
        this.totalSpace3 = totalSpace3;
        this.remainSpace3 = remainSpace3;
        this.usage3 = usage3;
        this.asmName4 = asmName4;
        this.totalSpace4 = totalSpace4;
        this.remainSpace4 = remainSpace4;
        this.usage4 = usage4;
    }

    public String getAsmName3() {
        return asmName3;
    }

    public void setAsmName3(String asmName3) {
        this.asmName3 = asmName3;
    }

    public Integer getTotalSpace3() {
        return totalSpace3;
    }

    public void setTotalSpace3(Integer totalSpace3) {
        this.totalSpace3 = totalSpace3;
    }

    public Integer getRemainSpace3() {
        return remainSpace3;
    }

    public void setRemainSpace3(Integer remainSpace3) {
        this.remainSpace3 = remainSpace3;
    }

    public Float getUsage3() {
        return usage3;
    }

    public void setUsage3(Float usage3) {
        this.usage3 = usage3;
    }

    public String getAsmName4() {
        return asmName4;
    }

    public void setAsmName4(String asmName4) {
        this.asmName4 = asmName4;
    }

    public Integer getTotalSpace4() {
        return totalSpace4;
    }

    public void setTotalSpace4(Integer totalSpace4) {
        this.totalSpace4 = totalSpace4;
    }

    public Integer getRemainSpace4() {
        return remainSpace4;
    }

    public void setRemainSpace4(Integer remainSpace4) {
        this.remainSpace4 = remainSpace4;
    }

    public Float getUsage4() {
        return usage4;
    }

    public void setUsage4(Float usage4) {
        this.usage4 = usage4;
    }

    @Override
    public String toString() {
        return "Sheet423CoreModel{" +
                "date=" + date +
                ", asmName3='" + asmName3 +
                ", totalSpace3=" + totalSpace3 +
                ", remainSpace3=" + remainSpace3 +
                ", usage3=" + usage3 +
                ", asmName4='" + asmName4 +
                ", totalSpace4=" + totalSpace4 +
                ", remainSpace4=" + remainSpace4 +
                ", usage4=" + usage4 +
                '}';
    }
}
