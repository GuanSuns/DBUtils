package org.suns.model;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429CoreModel extends Sheet429PersonalModel {
    private String heartBeat2;
    private String heartBeat3;

    public Sheet429CoreModel() {
        this.heartBeat2 = "";
        this.heartBeat3 = "";
    }

    public Sheet429CoreModel(String heartBeat2, String heartBeat3) {
        this.heartBeat2 = heartBeat2;
        this.heartBeat3 = heartBeat3;
    }

    public String getHeartBeat2() {
        return heartBeat2;
    }

    public void setHeartBeat2(String heartBeat2) {
        this.heartBeat2 = heartBeat2;
    }

    public String getHeartBeat3() {
        return heartBeat3;
    }

    public void setHeartBeat3(String heartBeat3) {
        this.heartBeat3 = heartBeat3;
    }
}
