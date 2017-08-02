package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet411CoreDao;
import org.suns.database.utils.dao.Sheet411PersonalDao;
import org.suns.database.utils.dao.Sheet421CoreDao;
import org.suns.database.utils.dao.Sheet421PersonalDao;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.database.utils.model.Sheet421PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421Controller {
    private static Sheet421CoreDao sheet421CoreDao;
    private static Sheet421PersonalDao sheet421PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet421CoreDao = new Sheet421CoreDao();
        sheet421PersonalDao = new Sheet421PersonalDao();
    }


    public static boolean addPersonal(Sheet421PersonalModel sheet421PersonalModel)
            throws Exception{

        if(sheet421PersonalModel == null){
            return false;
        }

        preCheck();
        sheet421PersonalDao.addInstance(sheet421PersonalModel);

        return true;
    }

    public static boolean addCore(Sheet421CoreModel sheet421CoreModel)
            throws Exception{

        if(sheet421CoreModel == null){
            return false;
        }

        preCheck();
        sheet421CoreDao.addInstance(sheet421CoreModel);
        return true;
    }

    public static ArrayList<Sheet421PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        preCheck();
        return sheet421PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet421CoreModel> getRecentInstancesCore(int days) throws Exception{
        preCheck();
        return sheet421CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet421PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet421CoreDao.abortRecentInstances(minutes);
    }

    public static void clearAll() throws Exception{
        preCheck();
        sheet421CoreDao.clearAll();
        sheet421PersonalDao.clearAll();
    }
}
