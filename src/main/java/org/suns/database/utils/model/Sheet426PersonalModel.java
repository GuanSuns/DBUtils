package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426PersonalModel extends AbstractDataModel{
    protected Timestamp date;
    protected int errorInfo20;
    protected String log20;
    protected int errorInfo21;
    protected String log21;

    public Sheet426PersonalModel(Timestamp date, int errorInfo20
            , String log20, int errorInfo21, String log21) {
        this.date = date;
        this.errorInfo20 = errorInfo20;
        this.log20 = log20;
        this.errorInfo21 = errorInfo21;
        this.log21 = log21;
    }

    public Sheet426PersonalModel() {
        this.date = null;
        this.errorInfo20 = 0;
        this.log20 = "";
        this.errorInfo21 = 0;
        this.log21 = "";
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getErrorInfo20() {
        return errorInfo20;
    }

    public void setErrorInfo20(int errorInfo20) {
        this.errorInfo20 = errorInfo20;
    }

    public String getLog20() {
        return log20;
    }

    public void setLog20(String log20) {
        this.log20 = log20;
    }

    public int getErrorInfo21() {
        return errorInfo21;
    }

    public void setErrorInfo21(int errorInfo21) {
        this.errorInfo21 = errorInfo21;
    }

    public String getLog21() {
        return log21;
    }

    public void setLog21(String log21) {
        this.log21 = log21;
    }

    @Override
    public String toString() {
        return "Sheet426PersonalModel{" +
                "date=" + date +
                ", errorInfo20=" + errorInfo20 +
                ", log20='" + log20 +
                ", errorInfo21=" + errorInfo21 +
                ", log21='" + log21 +
                '}';
    }
}
