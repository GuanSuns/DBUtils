package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421PersonalModel extends AbstractDataModel{
    protected Timestamp date;

    protected Float usage2;
    protected Float u01Usage2;
    protected Float goldUsage2;

    protected Float usage3;
    protected Float u01Usage3;
    protected Float goldUsage3;

    protected Float usage4;
    protected Float u01Usage4;
    protected Float goldUsage4;

    public Sheet421PersonalModel() {
        this.date = null;
        this.u01Usage2 = 0F;
        this.u01Usage2 = 0F;
        this.goldUsage2 = 0F;
        this.usage3 = 0F;
        this.u01Usage3 = 0F;
        this.goldUsage3 = 0F;
        this.usage4 = 0F;
        this.u01Usage4 = 0F;
        this.goldUsage4 = 0F;
    }

    public Sheet421PersonalModel(Timestamp date
            , Float usage2, Float u01Usage2, Float goldUsage2
            , Float usage3, Float u01Usage3, Float goldUsage3
            , Float usage4, Float u01Usage4, Float goldUsage4) {
        this.date = date;
        this.usage2 = usage2;
        this.u01Usage2 = u01Usage2;
        this.goldUsage2 = goldUsage2;
        this.usage3 = usage3;
        this.u01Usage3 = u01Usage3;
        this.goldUsage3 = goldUsage3;
        this.usage4 = usage4;
        this.u01Usage4 = u01Usage4;
        this.goldUsage4 = goldUsage4;
    }

    public Timestamp getDate() {
        return date;
    }

    public Float getUsage2() {
        return usage2;
    }

    public Float getU01Usage2() {
        return u01Usage2;
    }

    public Float getGoldUsage2() {
        return goldUsage2;
    }

    public Float getUsage3() {
        return usage3;
    }

    public Float getU01Usage3() {
        return u01Usage3;
    }

    public Float getGoldUsage3() {
        return goldUsage3;
    }

    public Float getUsage4() {
        return usage4;
    }

    public Float getU01Usage4() {
        return u01Usage4;
    }

    public Float getGoldUsage4() {
        return goldUsage4;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setUsage2(Float usage2) {
        this.usage2 = usage2;
    }

    public void setU01Usage2(Float u01Usage2) {
        this.u01Usage2 = u01Usage2;
    }

    public void setGoldUsage2(Float goldUsage2) {
        this.goldUsage2 = goldUsage2;
    }

    public void setUsage3(Float usage3) {
        this.usage3 = usage3;
    }

    public void setU01Usage3(Float u01Usage3) {
        this.u01Usage3 = u01Usage3;
    }

    public void setGoldUsage3(Float goldUsage3) {
        this.goldUsage3 = goldUsage3;
    }

    public void setUsage4(Float usage4) {
        this.usage4 = usage4;
    }

    public void setU01Usage4(Float u01Usage4) {
        this.u01Usage4 = u01Usage4;
    }

    public void setGoldUsage4(Float goldUsage4) {
        this.goldUsage4 = goldUsage4;
    }

    @Override
    public String toString() {
        return "Sheet421PersonalModel{" +
                "date=" + date +
                ", usage2=" + usage2 +
                ", u01Usage2=" + u01Usage2 +
                ", goldUsage2=" + goldUsage2 +
                ", usage3=" + usage3 +
                ", u01Usage3=" + u01Usage3 +
                ", goldUsage3=" + goldUsage3 +
                ", usage4=" + usage4 +
                ", u01Usage4=" + u01Usage4 +
                ", goldUsage4=" + goldUsage4 +
                "} " + super.toString();
    }
}
