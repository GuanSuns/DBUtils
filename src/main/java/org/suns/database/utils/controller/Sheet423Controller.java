package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet423CoreDao;
import org.suns.database.utils.dao.Sheet423PersonalDao;
import org.suns.database.utils.model.Sheet423CoreModel;
import org.suns.database.utils.model.Sheet423PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423Controller {
    private static Sheet423CoreDao sheet423CoreDao;
    private static Sheet423PersonalDao sheet423PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet423CoreDao = new Sheet423CoreDao();
        sheet423PersonalDao = new Sheet423PersonalDao();
    }

    public static boolean addPersonal(Sheet423PersonalModel sheet423PersonalModel)
            throws Exception{

        if(sheet423PersonalModel == null){
            return false;
        }

        preCheck();
        sheet423PersonalDao.addInstance(sheet423PersonalModel);
        return true;
    }

    public static boolean addCore(Sheet423CoreModel sheet423CoreModel) throws Exception{
        if(sheet423CoreModel == null){
            return false;
        }

        preCheck();
        sheet423CoreDao.addInstance(sheet423CoreModel);
        return true;
    }

    public static ArrayList<Sheet423PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        preCheck();
        return sheet423PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet423CoreModel> getRecentInstancesCore(int days) throws Exception{
        preCheck();
        return sheet423CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet423PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet423CoreDao.abortRecentInstances(minutes);
    }
}
