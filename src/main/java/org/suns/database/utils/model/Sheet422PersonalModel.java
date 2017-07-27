package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422PersonalModel extends AbstractUsageModel{
    protected Timestamp date;

    protected String name2;
    protected Float totalSpace2;
    protected Float usedSpace2;
    protected Float usage2;

    public Sheet422PersonalModel() {
        this.date = null;
        this.name2 = "";
        this.totalSpace2 = 0f;
        this.usedSpace2 = 0f;
        this.usage2 = 0f;
    }

    public Sheet422PersonalModel(Timestamp date, String tsName2
            , Float tsTotalSpace2, Float tsUsedSpace2, Float tsUsage2) {
        this.date = date;
        this.name2 = tsName2;
        this.totalSpace2 = tsTotalSpace2;
        this.usedSpace2 = tsUsedSpace2;
        this.usage2 = tsUsage2;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String getName2() {
        return name2;
    }

    @Override
    public void setName2(String name) {
        this.name2 = name;
    }

    @Override
    public Float getTotalSpace2() {
        return totalSpace2;
    }

    @Override
    public void setTotalSpace2(Float totalSpace) {
        this.totalSpace2 = totalSpace;
    }

    @Override
    public Float getUsedOrRemainSpace2() {
        return usedSpace2;
    }

    @Override
    public void setUsedOrRemainSpace2(Float usedOrRemainSpace) {
        this.usedSpace2 = usedOrRemainSpace;
    }

    @Override
    public Float getUsage2() {
        return usage2;
    }

    @Override
    public void setUsage2(Float usage) {
        this.usage2 = usage;
    }

    @Override
    public String getName3() {
        return null;
    }

    @Override
    public void setName3(String name) {

    }

    @Override
    public Float getTotalSpace3() {
        return null;
    }

    @Override
    public void setTotalSpace3(Float totalSpace) {

    }

    @Override
    public Float getUsedOrRemainSpace3() {
        return null;
    }

    @Override
    public void setUsedOrRemainSpace3(Float usedOrRemainSpace) {

    }

    @Override
    public Float getUsage3() {
        return null;
    }

    @Override
    public void setUsage3(Float usage) {

    }

    @Override
    public String getName4() {
        return null;
    }

    @Override
    public void setName4(String name) {

    }

    @Override
    public Float getTotalSpace4() {
        return null;
    }

    @Override
    public void setTotalSpace4(Float totalSpace) {

    }

    @Override
    public Float getUsedOrRemainSpace4() {
        return null;
    }

    @Override
    public void setUsedOrRemainSpace4(Float usedOrRemainSpace) {

    }

    @Override
    public Float getUsage4() {
        return null;
    }

    @Override
    public void setUsage4(Float usage) {

    }

    @Override
    public String toString() {
        return "Sheet422PersonalModel{" +
                "date=" + date +
                ", tsName2='" + name2 +
                ", tsTotalSpace2=" + totalSpace2 +
                ", tsUsedSpace2=" + usedSpace2 +
                ", tsUsage2=" + usage2 +
                '}';
    }
}
