package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet426CoreDao;
import org.suns.database.utils.dao.Sheet426PersonalDao;
import org.suns.database.utils.model.Sheet426CoreModel;
import org.suns.database.utils.model.Sheet426PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 7/4/2017.
 */
public class Sheet426Controller {
    private static Sheet426CoreDao sheet426CoreDao;
    private static Sheet426PersonalDao sheet426PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet426CoreDao = new Sheet426CoreDao();
        sheet426PersonalDao = new Sheet426PersonalDao();
    }

    public static boolean addPersonal(Sheet426PersonalModel sheet426PersonalModel) throws Exception{
        if(sheet426PersonalModel == null){
            return false;
        }

        preCheck();
        sheet426PersonalDao.addInstance(sheet426PersonalModel);
        return true;
    }

    public static boolean addCore(Sheet426CoreModel sheet426CoreModel) throws Exception{
        if(sheet426CoreModel == null){
            return false;
        }

        preCheck();
        sheet426CoreDao.addInstance(sheet426CoreModel);
        return true;
    }

    public static ArrayList<Sheet426PersonalModel> getRecentInstancesPersonal(int days)
            throws Exception{
        preCheck();
        return sheet426PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet426CoreModel> getRecentInstancesCore(int days)
            throws Exception{
        preCheck();
        return sheet426CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet426PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet426CoreDao.abortRecentInstances(minutes);
    }
}
