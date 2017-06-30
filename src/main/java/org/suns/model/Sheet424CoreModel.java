package org.suns.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424CoreModel extends Sheet424PersonalModel{

    private Timestamp inspectTime3;
    private String status3;

    private Timestamp inspectTime4;
    private String status4;

    public Sheet424CoreModel() {
        super();
        this.inspectTime3 = null;
        this.status3 = "";
        this.inspectTime4 = null;
        this.status4 = "";
    }

    public Sheet424CoreModel(Timestamp date, Timestamp inspectTime2
            , String status2, Timestamp inspectTime3, String status3
            , Timestamp inspectTime4, String status4) {
        super(date, inspectTime2, status2);
        this.inspectTime3 = inspectTime3;
        this.status3 = status3;
        this.inspectTime4 = inspectTime4;
        this.status4 = status4;
    }

    public Timestamp getInspectTime3() {
        return inspectTime3;
    }

    public void setInspectTime3(Timestamp inspectTime3) {
        this.inspectTime3 = inspectTime3;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
    }

    public Timestamp getInspectTime4() {
        return inspectTime4;
    }

    public void setInspectTime4(Timestamp inspectTime4) {
        this.inspectTime4 = inspectTime4;
    }

    public String getStatus4() {
        return status4;
    }

    public void setStatus4(String status4) {
        this.status4 = status4;
    }
}
