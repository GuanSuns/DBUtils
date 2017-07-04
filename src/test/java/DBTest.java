import org.junit.Test;
import org.suns.database.utils.dao.*;
import org.suns.database.utils.model.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by guanl on 6/28/2017.
 */
public class DBTest {
    @Test
    public void test_sheet411(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -2);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        //Sheet424PersonalModel sheet411PersonalModel = new Sheet424PersonalModel(currentTime,currentTime, "test String");
        Sheet426CoreModel sheet426CoreModel = new Sheet426CoreModel(currentTime
                , 0, "Test Log 2", 1, "Test Log3"
                , 0, "Test Log 4");
        try{
            Sheet426CoreDao.addInstance(sheet426CoreModel);
            /*
            ArrayList<Sheet411PersonalModel> models = Sheet411PersonalDao.getRecentInstances(2);
            for(Sheet411PersonalModel model : models){
                System.out.println(model.toString());
            }*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet411Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 0);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet411CoreModel sheet411CoreModel = new Sheet411CoreModel(currentTime, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.08f, 0.09f, 0.10f, 0.11f, 0.12f, 0.13f, 0.12f, 0.13f);
        try{
            Sheet411CoreDao.addInstance(sheet411CoreModel);

            ArrayList<Sheet411CoreModel> models = Sheet411CoreDao.getRecentInstances(2);
            for(Sheet411CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet422Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet422CoreModel sheet422CoreModel = new Sheet422CoreModel(currentTime, "test 1", 2.3f, 1.23f, 0.23f
                , "test 2", 2.31213f, 11.23f, 0.233f
                , "test 3", 2.3324f, 12.23f, 0.212f);
        try{
            Sheet422CoreDao.addInstance(sheet422CoreModel);

            ArrayList<Sheet422CoreModel> models = Sheet422CoreDao.getRecentInstances(2);
            for(Sheet422CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
