import org.junit.Test;
import org.suns.database.utils.config.*;
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

    //@Test
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

    //@Test
    public void test_sheet423Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet423PersonalModel sheet423PersonalModel = new Sheet423PersonalModel(currentTime
                , "test 1", 2, 12, 0.212f);
        try{
            Sheet423Config.setConfigToOracle();
            Sheet423PersonalDao.addInstance(sheet423PersonalModel);

            ArrayList<Sheet423PersonalModel> models = Sheet423PersonalDao
                    .getRecentInstances(2);
            for(Sheet423PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet423Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet423CoreModel sheet423CoreModel = new Sheet423CoreModel(currentTime
                , "test 1", 2, 12
                , 0.212f, "test 1", 2
                , 12, 0.212f, "test 1"
                , 2, 12, 0.212f);
        try{
            Sheet423Config.setConfigToOracle();
            Sheet423CoreDao.addInstance(sheet423CoreModel);

            ArrayList<Sheet423CoreModel> models = Sheet423CoreDao
                    .getRecentInstances(2);
            for(Sheet423CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet424Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet424CoreModel sheet424CoreModel = new Sheet424CoreModel(currentTime
                , currentTime, "test 1"
                , currentTime, "test 1"
                , currentTime, "test 1");
        try{
            Sheet424Config.setConfigToOracle();
            Sheet424CoreDao.addInstance(sheet424CoreModel);

            ArrayList<Sheet424CoreModel> models = Sheet424CoreDao
                    .getRecentInstances(2);
            for(Sheet424CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet424Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet424PersonalModel sheet424PersonalModel = new Sheet424PersonalModel(currentTime
                , currentTime, "test 1");
        try{
            Sheet424Config.setConfigToOracle();
            Sheet424PersonalDao.addInstance(sheet424PersonalModel);

            ArrayList<Sheet424PersonalModel> models = Sheet424PersonalDao
                    .getRecentInstances(2);
            for(Sheet424PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet426Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet426PersonalModel sheet426PersonalModel = new Sheet426PersonalModel(currentTime
                , 1, "Error Info 1"
                , 1, "Error Info 2");
        try{
            Sheet426Config.setConfigToOracle();
            Sheet426PersonalDao.addInstance(sheet426PersonalModel);

            ArrayList<Sheet426PersonalModel> models = Sheet426PersonalDao
                    .getRecentInstances(2);
            for(Sheet426PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet426Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet426CoreModel sheet426CoreModel = new Sheet426CoreModel(currentTime
                , 1, "Error Info 1"
                , 1, "Error Info 2"
                , 0, "Error Info 3"
                , 1, "Error Info 4"
                , 0, "Error Info 5");
        try{
            Sheet426Config.setConfigToOracle();
            Sheet426CoreDao.addInstance(sheet426CoreModel);

            ArrayList<Sheet426CoreModel> models = Sheet426CoreDao
                    .getRecentInstances(2);
            for(Sheet426CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //@Test
    public void test_sheet428Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet428CoreModel sheet428CoreModel = new Sheet428CoreModel(currentTime
                , "Error Info 1"
                , "Error Info 2"
                , "Error Info 3"
                , "Error Info 4"
                , "Error Info 5");
        try{
            Sheet428Config.setConfigToOracle();
            Sheet428CoreDao.addInstance(sheet428CoreModel);

            ArrayList<Sheet428CoreModel> models = Sheet428CoreDao
                    .getRecentInstances(2);
            for(Sheet428CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet428Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet428PersonalModel sheet428PersonalModel = new Sheet428PersonalModel(currentTime
                , "Error Info 1"
                , "Error Info 2"
                , "Error Info 3"
                , "Error Info 4");
        try{
            Sheet428Config.setConfigToOracle();
            Sheet428PersonalDao.addInstance(sheet428PersonalModel);

            ArrayList<Sheet428PersonalModel> models = Sheet428PersonalDao
                    .getRecentInstances(2);
            for(Sheet428PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet429Personal(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet429PersonalModel sheet429PersonalModel = new Sheet429PersonalModel(currentTime
                , "Error Info 1");
        try{
            Sheet429Config.setConfigToOracle();
            Sheet429PersonalDao.addInstance(sheet429PersonalModel);

            ArrayList<Sheet429PersonalModel> models = Sheet429PersonalDao
                    .getRecentInstances(2);
            for(Sheet429PersonalModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //@Test
    public void test_sheet429Core(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);
        date = calendar.getTime();
        Timestamp currentTime = new Timestamp(date.getTime());
        Sheet429CoreModel sheet429CoreModel = new Sheet429CoreModel(currentTime
                , "Error Info 1"
                , "Error Info 2"
                , "Error Info 3");
        try{
            Sheet429Config.setConfigToOracle();
            Sheet429CoreDao.addInstance(sheet429CoreModel);

            ArrayList<Sheet429CoreModel> models = Sheet429CoreDao
                    .getRecentInstances(2);
            for(Sheet429CoreModel model : models){
                System.out.println(model.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
