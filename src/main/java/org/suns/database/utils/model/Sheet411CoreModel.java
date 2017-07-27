package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/28/2017.
 */
public class Sheet411CoreModel extends Sheet411PersonalModel{
    private Float usage8;
    private Float weblogicUsage8;

    public Sheet411CoreModel() {
        super();
        this.usage8 = 0F;
        this.weblogicUsage8 = 0F;
    }

    public Sheet411CoreModel(Timestamp date, Float usage2, Float weblogicUsage2
            , Float usage3, Float weblogicUsage3
            , Float usage4, Float weblogicUsage4
            , Float usage5, Float weblogicUsage5
            , Float usage6, Float weblogicUsage6
            , Float usage7, Float weblogicUsage7
            , Float usage8, Float weblogicUsage8) {
        super(date, usage2, weblogicUsage2, usage3, weblogicUsage3
                , usage4, weblogicUsage4, usage5, weblogicUsage5
                , usage6, weblogicUsage6, usage7, weblogicUsage7);
        this.usage8 = usage8;
        this.weblogicUsage8 = weblogicUsage8;
    }

    public Float getUsage8() {
        return usage8;
    }

    public Float getWeblogicUsage8() {
        return weblogicUsage8;
    }

    public void setUsage8(Float usage8) {
        this.usage8 = usage8;
    }

    public void setWeblogicUsage8(Float weblogicUsage8) {
        this.weblogicUsage8 = weblogicUsage8;
    }

    @Override
    public String toString() {
        return "Sheet411CoreModel{" +
                "date=" + date.toString() +
                ", usage2=" + usage2 +
                ", weblogicUsage2=" + weblogicUsage2 +
                ", usage3=" + usage3 +
                ", weblogicUsage3=" + weblogicUsage3 +
                ", usage4=" + usage4 +
                ", weblogicUsage4=" + weblogicUsage4 +
                ", usage5=" + usage5 +
                ", weblogicUsage5=" + weblogicUsage5 +
                ", usage6=" + usage6 +
                ", weblogicUsage6=" + weblogicUsage6 +
                ", usage7=" + usage7 +
                ", weblogicUsage7=" + weblogicUsage7 +
                ", usage8=" + usage8 +
                ", weblogicUsage8=" + weblogicUsage8 +
                '}';
    }
}
