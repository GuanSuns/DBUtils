package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet424CoreDao;
import org.suns.database.utils.dao.Sheet424PersonalDao;
import org.suns.database.utils.model.Sheet424CoreModel;
import org.suns.database.utils.model.Sheet424PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet424Controller {
    private static Sheet424CoreDao sheet424CoreDao;
    private static Sheet424PersonalDao sheet424PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet424CoreDao = new Sheet424CoreDao();
        sheet424PersonalDao = new Sheet424PersonalDao();
    }

    public static boolean addPersonal(Sheet424PersonalModel sheet424PersonalModel) throws Exception{
        if(sheet424PersonalModel == null){
            return false;
        }

        preCheck();
        sheet424PersonalDao.addInstance(sheet424PersonalModel);
        return true;
    }

    public static boolean addCore(Sheet424CoreModel sheet424CoreModel) throws Exception{
        if(sheet424CoreModel == null){
            return false;
        }

        preCheck();
        sheet424CoreDao.addInstance(sheet424CoreModel);
        return true;
    }

    public static ArrayList<Sheet424PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        preCheck();
        return sheet424PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet424CoreModel> getRecentInstancesCore(int days) throws Exception{
        preCheck();
        return sheet424CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet424PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet424CoreDao.abortRecentInstances(minutes);
    }

    public static void clearAll() throws Exception{
        preCheck();
        sheet424CoreDao.clearAll();
        sheet424PersonalDao.clearAll();
    }
}
