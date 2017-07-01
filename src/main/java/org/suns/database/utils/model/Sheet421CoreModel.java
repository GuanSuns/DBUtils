package org.suns.database.utils.model;

import java.sql.Timestamp;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421CoreModel extends Sheet421PersonalModel{

    private Float usage5;
    private Float u01Usage5;
    private Float goldUsage5;

    public Sheet421CoreModel() {
        super();
        this.usage5 = 0f;
        this.u01Usage5 = 0f;
        this.goldUsage5 = 0f;
    }

    public Sheet421CoreModel(Timestamp date
            , Float usage2, Float u01Usage2, Float goldUsage2
            , Float usage3, Float u01Usage3, Float goldUsage3
            , Float usage4, Float u01Usage4, Float goldUsage4
            , Float usage5, Float u01Usage5, Float goldUsage5) {
        super(date, usage2, u01Usage2, goldUsage2
                , usage3, u01Usage3, goldUsage3
                , usage4, u01Usage4, goldUsage4);
        this.usage5 = usage5;
        this.u01Usage5 = u01Usage5;
        this.goldUsage5 = goldUsage5;
    }

    public Float getUsage5() {
        return usage5;
    }

    public void setUsage5(Float usage5) {
        this.usage5 = usage5;
    }

    public Float getU01Usage5() {
        return u01Usage5;
    }

    public void setU01Usage5(Float u01Usage5) {
        this.u01Usage5 = u01Usage5;
    }

    public Float getGoldUsage5() {
        return goldUsage5;
    }

    public void setGoldUsage5(Float goldUsage5) {
        this.goldUsage5 = goldUsage5;
    }
}
