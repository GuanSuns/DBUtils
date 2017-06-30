package org.suns.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428PersonalModel {
    private Timestamp date;

    private String status1;
    private String status2;
    private String status3;
    private String status4;

    public Sheet428PersonalModel() {
        this.date = null;
        this.status1 = this.status2 = this.status3 = this.status4 = "";
    }

    public Sheet428PersonalModel(Timestamp date, String status1
            , String status2, String status3, String status4) {
        this.date = date;
        this.status1 = status1;
        this.status2 = status2;
        this.status3 = status3;
        this.status4 = status4;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
    }

    public String getStatus4() {
        return status4;
    }

    public void setStatus4(String status4) {
        this.status4 = status4;
    }
}
