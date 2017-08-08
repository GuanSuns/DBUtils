package org.suns.database.utils.controller;

import org.suns.database.utils.dao.DailyAppCoreDao;
import org.suns.database.utils.dao.DailyAppPersonalDao;
import org.suns.database.utils.model.DailyAppInspectionModel;

import java.util.ArrayList;

public class DailyAppController {
    private static DailyAppCoreDao appCoreDao;
    private static DailyAppPersonalDao appPersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        appCoreDao = new DailyAppCoreDao();
        appPersonalDao = new DailyAppPersonalDao();
    }

    public static boolean addPersonal(DailyAppInspectionModel appPersonalModel)
            throws Exception{
        if(appPersonalModel == null){
            return false;
        }

        preCheck();
        appPersonalDao.addInstance(appPersonalModel);
        return true;
    }

    public static boolean addCore(DailyAppInspectionModel appCoreModel)
            throws Exception{
        if(appCoreModel == null){
            return false;
        }

        preCheck();
        appCoreDao.addInstance(appCoreModel);
        return true;
    }

    public static ArrayList<DailyAppInspectionModel> getRecentInstancesPersonal(int days)
            throws Exception{
        preCheck();
        return appPersonalDao.getRecentInstances(days);
    }

    public static ArrayList<DailyAppInspectionModel> getRecentInstancesCore(int days)
            throws Exception{
        preCheck();
        return appCoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        appPersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        appCoreDao.abortRecentInstances(minutes);
    }

    public static void clearAll() throws Exception{
        preCheck();
        appPersonalDao.clearAll();
        appCoreDao.clearAll();
    }
}
