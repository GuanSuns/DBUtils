package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet411CoreDao;
import org.suns.database.utils.dao.Sheet411PersonalDao;
import org.suns.database.utils.model.Sheet411CoreModel;
import org.suns.database.utils.model.Sheet411PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet411Controller {
    private static Sheet411CoreDao sheet411CoreDao;
    private static Sheet411PersonalDao sheet411PersonalDao;
    private static boolean isInitialized = false;

    private static void init(){
        sheet411CoreDao = new Sheet411CoreDao();
        sheet411PersonalDao = new Sheet411PersonalDao();
    }

    public static boolean addPersonal(Sheet411PersonalModel sheet411PersonalModel){
        if(sheet411PersonalModel == null){
            return false;
        }

        if(!isInitialized){
            init();
            isInitialized = true;
        }

        try{
            sheet411PersonalDao.addInstance(sheet411PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet411CoreModel sheet411CoreModel){
        if(sheet411CoreModel == null){
            return false;
        }

        if(!isInitialized){
            init();
            isInitialized = true;
        }

        try{
            sheet411CoreDao.addInstance(sheet411CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet411PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return sheet411PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet411CoreModel> getRecentInstancesCore(int days) throws Exception{
        return sheet411CoreDao.getRecentInstances(days);
    }
}
