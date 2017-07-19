package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424PersonalModel {
    private Timestamp date;

    private Timestamp inspectTime2;
    private String status2;

    public Sheet424PersonalModel(Timestamp date
            , Timestamp inspectTime2, String status2) {
        this.date = date;
        this.inspectTime2 = inspectTime2;
        this.status2 = status2;
    }

    public Sheet424PersonalModel() {
        date = null;
        this.inspectTime2 = null;
        this.status2 = "";
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getInspectTime2() {
        return inspectTime2;
    }

    public void setInspectTime2(Timestamp inspectTime2) {
        this.inspectTime2 = inspectTime2;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    @Override
    public String toString() {
        return "Sheet424PersonalModel{" +
                "date=" + date +
                ", inspectTime2=" + inspectTime2 +
                ", status2='" + status2 +
                '}';
    }
}
