package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426CoreModel extends Sheet426PersonalModel {

    private int errorInfo3;
    private String log3;
    private int errorInfo4;
    private String log4;

    public Sheet426CoreModel() {
        super();
        this.errorInfo3 = 0;
        this.log3 = "";
        this.errorInfo4 = 0;
        this.log4 = "";
    }

    public Sheet426CoreModel(Timestamp date, int errorInfo2, String log2
            , int errorInfo3, String log3, int errorInfo4, String log4) {
        super(date, errorInfo2, log2);
        this.errorInfo3 = errorInfo3;
        this.log3 = log3;
        this.errorInfo4 = errorInfo4;
        this.log4 = log4;
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

    public int getErrorInfo4() {
        return errorInfo4;
    }

    public void setErrorInfo4(int errorInfo4) {
        this.errorInfo4 = errorInfo4;
    }

    public String getLog4() {
        return log4;
    }

    public void setLog4(String log4) {
        this.log4 = log4;
    }
}
