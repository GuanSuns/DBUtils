import org.junit.Test;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.Sheet411Config;
import org.suns.database.utils.config.Sheet421Config;
import org.suns.database.utils.config.Sheet422Config;
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
    //@Test
    public void test_sheet411Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -2);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet411PersonalModel sheet411PersonalModel = new Sheet411PersonalModel(currentTime
                , 0.2f, 0.3f, 0.4f, 0.5f
                , 0.6f, 0.7f, 0.08f, 0.09f
                , 0.6f, 0.7f, 0.08f, 0.09f);

        try{
            Sheet411Config.setConfigToOracle();
            Sheet411PersonalDao.addInstance(sheet411PersonalModel);

            ArrayList<Sheet411PersonalModel> models = Sheet411PersonalDao
                    .getRecentInstances(2);
            for(Sheet411PersonalModel model : models){
                System.out.println(model.toString());
            }

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
        Sheet411CoreModel sheet411CoreModel = new Sheet411CoreModel(currentTime, 0.2f
                , 0.3f, 0.4f, 0.5f, 0.6f
                , 0.7f, 0.08f, 0.09f, 0.10f
                , 0.11f, 0.12f, 0.13f, 0.12f
                , 0.13f);
        try{
            Sheet411Config.setConfigToOracle();
            Sheet411CoreDao.addInstance(sheet411CoreModel);

            ArrayList<Sheet411CoreModel> models = Sheet411CoreDao.getRecentInstances(365);
            for(Sheet411CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet421Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -2);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet421PersonalModel sheet421PersonalModel = new Sheet421PersonalModel(currentTime
                , 0.2f, 0.3f, 0.4f
                , 0.5f, 0.6f, 0.7f
                , 0.08f, 0.09f, 0.6f);

        try{
            Sheet421Config.setConfigToOracle();
            Sheet421PersonalDao.addInstance(sheet421PersonalModel);

            ArrayList<Sheet421PersonalModel> models = Sheet421PersonalDao
                    .getRecentInstances(2);
            for(Sheet421PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet421Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -2);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet421CoreModel sheet421CoreModel = new Sheet421CoreModel(currentTime
                , 0.2f, 0.3f, 0.4f
                , 0.2f, 0.3f, 0.4f
                , 0.5f, 0.6f, 0.7f
                , 0.08f, 0.09f, 0.6f);

        try{
            Sheet421Config.setConfigToOracle();
            Sheet421CoreDao.addInstance(sheet421CoreModel);

            ArrayList<Sheet421CoreModel> models = Sheet421CoreDao
                    .getRecentInstances(2);
            for(Sheet421CoreModel model : models){
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
            Sheet422Config.setConfigToOracle();
            Sheet422CoreDao.addInstance(sheet422CoreModel);

            ArrayList<Sheet422CoreModel> models = Sheet422CoreDao
                    .getRecentInstances(2);
            for(Sheet422CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test_sheet422Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet422PersonalModel sheet422PersonalModel = new Sheet422PersonalModel(currentTime
                , "test 3", 2.3324f, 12.23f, 0.212f);
        try{
            Sheet422Config.setConfigToOracle();
            Sheet422PersonalDao.addInstance(sheet422PersonalModel);

            ArrayList<Sheet422PersonalModel> models = Sheet422PersonalDao
                    .getRecentInstances(2);
            for(Sheet422PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
