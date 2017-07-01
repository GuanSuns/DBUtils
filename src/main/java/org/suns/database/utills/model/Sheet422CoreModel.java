package org.suns.database.utills.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422CoreModel extends Sheet422PersonalModel {

    private String tsName3;
    private Float tsTotalSpace3;
    private Float tsUsedSpace3;
    private Float tsUsage3;

    private String tsName4;
    private Float tsTotalSpace4;
    private Float tsUsedSpace4;
    private Float tsUsage4;

    public Sheet422CoreModel() {
        super();
        this.tsName3 = "";
        this.tsTotalSpace3 = 0f;
        this.tsUsedSpace3 = 0f;
        this.tsUsage3 = 0f;

        this.tsName4 = "";
        this.tsTotalSpace4 = 0f;
        this.tsUsedSpace4 = 0f;
        this.tsUsage4 = 0f;
    }

    public Sheet422CoreModel(Timestamp date, String tsName2
            , Float tsTotalSpace2, Float tsUsedSpace2
            , Float tsUsage2, String tsName3, Float tsTotalSpace3
            , Float tsUsedSpace3, Float tsUsage3, String tsName4, Float tsTotalSpace4
            , Float tsUsedSpace4, Float tsUsage4) {
        super(date, tsName2, tsTotalSpace2, tsUsedSpace2, tsUsage2);
        this.tsName3 = tsName3;
        this.tsTotalSpace3 = tsTotalSpace3;
        this.tsUsedSpace3 = tsUsedSpace3;
        this.tsUsage3 = tsUsage3;
        this.tsName4 = tsName4;
        this.tsTotalSpace4 = tsTotalSpace4;
        this.tsUsedSpace4 = tsUsedSpace4;
        this.tsUsage4 = tsUsage4;
    }

    public String getTsName3() {
        return tsName3;
    }

    public void setTsName3(String tsName3) {
        this.tsName3 = tsName3;
    }

    public Float getTsTotalSpace3() {
        return tsTotalSpace3;
    }

    public void setTsTotalSpace3(Float tsTotalSpace3) {
        this.tsTotalSpace3 = tsTotalSpace3;
    }

    public Float getTsUsedSpace3() {
        return tsUsedSpace3;
    }

    public void setTsUsedSpace3(Float tsUsedSpace3) {
        this.tsUsedSpace3 = tsUsedSpace3;
    }

    public Float getTsUsage3() {
        return tsUsage3;
    }

    public void setTsUsage3(Float tsUsage3) {
        this.tsUsage3 = tsUsage3;
    }

    public String getTsName4() {
        return tsName4;
    }

    public void setTsName4(String tsName4) {
        this.tsName4 = tsName4;
    }

    public Float getTsTotalSpace4() {
        return tsTotalSpace4;
    }

    public void setTsTotalSpace4(Float tsTotalSpace4) {
        this.tsTotalSpace4 = tsTotalSpace4;
    }

    public Float getTsUsedSpace4() {
        return tsUsedSpace4;
    }

    public void setTsUsedSpace4(Float tsUsedSpace4) {
        this.tsUsedSpace4 = tsUsedSpace4;
    }

    public Float getTsUsage4() {
        return tsUsage4;
    }

    public void setTsUsage4(Float tsUsage4) {
        this.tsUsage4 = tsUsage4;
    }

    @Override
    public String toString() {
        return "Sheet422CoreModel{" +
                "date=" + date +
                ", tsName3='" + tsName3 +
                ", tsName2='" + tsName2 +
                ", tsTotalSpace3=" + tsTotalSpace3 +
                ", tsTotalSpace2=" + tsTotalSpace2 +
                ", tsUsedSpace3=" + tsUsedSpace3 +
                ", tsUsedSpace2=" + tsUsedSpace2 +
                ", tsUsage3=" + tsUsage3 +
                ", tsUsage2=" + tsUsage2 +
                ", tsName4='" + tsName4 +
                ", tsTotalSpace4=" + tsTotalSpace4 +
                ", tsUsedSpace4=" + tsUsedSpace4 +
                ", tsUsage4=" + tsUsage4 +
                '}';
    }
}
