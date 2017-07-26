package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet428CoreDao;
import org.suns.database.utils.dao.Sheet428PersonalDao;
import org.suns.database.utils.model.Sheet428CoreModel;
import org.suns.database.utils.model.Sheet428PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428Controller {
    private static Sheet428CoreDao sheet428CoreDao;
    private static Sheet428PersonalDao sheet428PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet428CoreDao = new Sheet428CoreDao();
        sheet428PersonalDao = new Sheet428PersonalDao();
    }

    public static boolean addPersonal(Sheet428PersonalModel sheet428PersonalModel)
            throws Exception{
        if(sheet428PersonalModel == null){
            return false;
        }

        preCheck();
        sheet428PersonalDao.addInstance(sheet428PersonalModel);
        return true;
    }

    public static boolean addCore(Sheet428CoreModel sheet428CoreModel) throws Exception{
        if(sheet428CoreModel == null){
            return false;
        }

        preCheck();
        sheet428CoreDao.addInstance(sheet428CoreModel);
        return true;
    }

    public static ArrayList<Sheet428PersonalModel> getRecentInstancesPersonal(int days)
            throws Exception{
        preCheck();
        return sheet428PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet428CoreModel> getRecentInstancesCore(int days)
            throws Exception{
        preCheck();
        return sheet428CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet428PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet428CoreDao.abortRecentInstances(minutes);
    }
}
