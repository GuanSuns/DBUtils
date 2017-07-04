package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreModel extends Sheet426PersonalModel {

    private int errorInfo3;
    private String log3;
    private int errorInfo40;
    private String log40;
    private int errorInfo41;
    private String log41;

    public Sheet426CoreModel() {
        super();
        this.errorInfo3 = 0;
        this.log3 = "";
        this.errorInfo40 = 0;
        this.log40 = "";
        this.errorInfo41 = 0;
        this.log41 = "";
    }

    public Sheet426CoreModel(Timestamp date, int errorInfo20
            , String log20, int errorInfo21, String log21
            , int errorInfo3, String log3, int errorInfo40
            , String log40, int errorInfo41, String log41) {
        super(date, errorInfo20, log20, errorInfo21, log21);
        this.errorInfo3 = errorInfo3;
        this.log3 = log3;
        this.errorInfo40 = errorInfo40;
        this.log40 = log40;
        this.errorInfo41 = errorInfo41;
        this.log41 = log41;
    }

    public int getErrorInfo3() {
        return errorInfo3;
    }

    public void setErrorInfo3(int errorInfo3) {
        this.errorInfo3 = errorInfo3;
    }

    public String getLog3() {
        return log3;
    }

    public void setLog3(String log3) {
        this.log3 = log3;
    }

    public int getErrorInfo40() {
        return errorInfo40;
    }

    public void setErrorInfo40(int errorInfo40) {
        this.errorInfo40 = errorInfo40;
    }

    public String getLog40() {
        return log40;
    }

    public void setLog40(String log40) {
        this.log40 = log40;
    }

    public int getErrorInfo41() {
        return errorInfo41;
    }

    public void setErrorInfo41(int errorInfo41) {
        this.errorInfo41 = errorInfo41;
    }

    public String getLog41() {
        return log41;
    }

    public void setLog41(String log41) {
        this.log41 = log41;
    }
}
