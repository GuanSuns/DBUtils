package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet422CoreDao;
import org.suns.database.utils.dao.Sheet422PersonalDao;
import org.suns.database.utils.model.Sheet422CoreModel;
import org.suns.database.utils.model.Sheet422PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet422Controller {
    private static Sheet422CoreDao sheet422CoreDao;
    private static Sheet422PersonalDao sheet422PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet422CoreDao = new Sheet422CoreDao();
        sheet422PersonalDao = new Sheet422PersonalDao();
    }


    public static boolean addPersonal(Sheet422PersonalModel sheet422PersonalModel)
            throws Exception{

        if(sheet422PersonalModel == null){
            return false;
        }

        preCheck();
        sheet422PersonalDao.addInstance(sheet422PersonalModel);
        return true;
    }

    public static boolean addCore(Sheet422CoreModel sheet422CoreModel)
            throws Exception{

        if(sheet422CoreModel == null){
            return false;
        }

        preCheck();
        sheet422CoreDao.addInstance(sheet422CoreModel);
        return true;
    }

    public static ArrayList<Sheet422PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        preCheck();
        return sheet422PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet422CoreModel> getRecentInstancesCore(int days) throws Exception{
        preCheck();
        return sheet422CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet422PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet422CoreDao.abortRecentInstances(minutes);
    }

    public static void clearAll() throws Exception{
        preCheck();
        sheet422CoreDao.clearAll();
        sheet422PersonalDao.clearAll();
    }
}
