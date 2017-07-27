package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423PersonalModel extends AbstractUsageModel{
    protected Timestamp date;
    private String name2;
    private Float totalSpace2;
    private Float remainSpace2;
    private Float usage2;

    public Sheet423PersonalModel() {
        this.date = null;
        this.name2 = "";
        this.totalSpace2 = 0f;
        this.remainSpace2 = 0f;
        this.usage2 = 0f;
    }

    public Sheet423PersonalModel(Timestamp date, String name2
            , Float totalSpace2, Float remainSpace2, Float usage2) {
        this.date = date;
        this.name2 = name2;
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
        return remainSpace2;
    }

    @Override
    public void setUsedOrRemainSpace2(Float usedOrRemainSpace) {
        this.remainSpace2 = usedOrRemainSpace;
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
        return "Sheet423PersonalModel{" +
                "date=" + date +
                ", name2='" + name2 +
                ", totalSpace2=" + totalSpace2 +
                ", remainSpace2=" + remainSpace2 +
                ", usage2=" + usage2 +
                '}';
    }
}
