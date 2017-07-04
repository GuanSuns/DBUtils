package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalModel {
    protected Timestamp date;
    protected int errorInfo2;
    protected String log2;

    public Sheet426PersonalModel() {
        this.date = null;
        this.errorInfo2 = 0;
        this.log2 = "";
    }

    public Sheet426PersonalModel(Timestamp date, int errorInfo2, String log2) {
        this.date = date;
        this.errorInfo2 = errorInfo2;
        this.log2 = log2;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getErrorInfo2() {
        return errorInfo2;
    }

    public void setErrorInfo2(int errorInfo2) {
        this.errorInfo2 = errorInfo2;
    }

    public String getLog2() {
        return log2;
    }

    public void setLog2(String log2) {
        this.log2 = log2;
    }
}
