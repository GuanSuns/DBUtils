package org.suns.database.utils.controller;

import org.suns.database.utils.dao.DailyDBCoreDao;
import org.suns.database.utils.dao.DailyDBPersonalDao;
import org.suns.database.utils.model.DailyDBInspectionModel;

import java.util.ArrayList;

public class DailyDBController {
    private static DailyDBCoreDao dbCoreDao;
    private static DailyDBPersonalDao dbPersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        dbCoreDao = new DailyDBCoreDao();
        dbPersonalDao = new DailyDBPersonalDao();
    }

    public static boolean addPersonal(DailyDBInspectionModel dbPersonalModel)
            throws Exception{
        if(dbPersonalModel == null){
            return false;
        }

        preCheck();
        dbPersonalDao.addInstance(dbPersonalModel);
        return true;
    }

    public static boolean addCore(DailyDBInspectionModel dbCoreModel)
            throws Exception{
        if(dbCoreModel == null){
            return false;
        }

        preCheck();
        dbCoreDao.addInstance(dbCoreModel);
        return true;
    }

    public static ArrayList<DailyDBInspectionModel> getRecentInstancesPersonal(int days)
            throws Exception{
        preCheck();
        return dbPersonalDao.getRecentInstances(days);
    }

    public static ArrayList<DailyDBInspectionModel> getRecentInstancesCore(int days)
            throws Exception{
        preCheck();
        return dbCoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        dbPersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        dbCoreDao.abortRecentInstances(minutes);
    }

    public static void clearAll() throws Exception{
        preCheck();
        dbPersonalDao.clearAll();
        dbCoreDao.clearAll();
    }
}
