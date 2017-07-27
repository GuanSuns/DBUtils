package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429PersonalModel extends AbstractDataModel{
    private Timestamp inspectTime;
    private String heartBeat1;

    public Sheet429PersonalModel() {
        inspectTime = null;
        heartBeat1 = "";
    }

    public Sheet429PersonalModel(Timestamp inspectTime, String heartBeat1) {
        this.inspectTime = inspectTime;
        this.heartBeat1 = heartBeat1;
    }

    public Timestamp getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Timestamp inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getHeartBeat1() {
        return heartBeat1;
    }

    public void setHeartBeat1(String heartBeat1) {
        this.heartBeat1 = heartBeat1;
    }

    @Override
    public String toString() {
        return "Sheet429PersonalModel{" +
                "inspectTime=" + inspectTime +
                ", heartBeat1='" + heartBeat1 +
                '}';
    }
}
