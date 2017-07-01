package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428CoreModel extends Sheet428PersonalModel{

    private String status5;

    public Sheet428CoreModel() {
        super();
        this.status5 = "";
    }

    public Sheet428CoreModel(Timestamp date, String status1
            , String status2, String status3
            , String status4, String status5) {
        super(date, status1, status2, status3, status4);
        this.status5 = status5;
    }

    public String getStatus5() {
        return status5;
    }

    public void setStatus5(String status5) {
        this.status5 = status5;
    }
}
