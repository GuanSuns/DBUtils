package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet429CoreDao;
import org.suns.database.utils.dao.Sheet429PersonalDao;
import org.suns.database.utils.model.Sheet429CoreModel;
import org.suns.database.utils.model.Sheet429PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet429Controller {
    private static Sheet429CoreDao sheet429CoreDao;
    private static Sheet429PersonalDao sheet429PersonalDao;
    private static boolean isInitialized = false;

    private static void preCheck(){
        if(!isInitialized){
            init();
            isInitialized = true;
        }
    }

    private static void init(){
        sheet429CoreDao = new Sheet429CoreDao();
        sheet429PersonalDao = new Sheet429PersonalDao();
    }
    
    
    public static boolean addPersonal(Sheet429PersonalModel sheet429PersonalModel)
            throws Exception{
        if(sheet429PersonalModel == null){
            return false;
        }

        preCheck();
        sheet429PersonalDao.addInstance(sheet429PersonalModel);
        return true;
    }

    public static boolean addCore(Sheet429CoreModel sheet429CoreModel) throws Exception{
        if(sheet429CoreModel == null){
            return false;
        }

        preCheck();
        sheet429CoreDao.addInstance(sheet429CoreModel);
        return true;
    }

    public static ArrayList<Sheet429PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        preCheck();
        return sheet429PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet429CoreModel> getRecentInstancesCore(int days) throws Exception{
        preCheck();
        return sheet429CoreDao.getRecentInstances(days);
    }

    public static void abortRecentPersonal(int minutes) throws Exception{
        preCheck();
        sheet429PersonalDao.abortRecentInstances(minutes);
    }

    public static void abortRecentCore(int minutes) throws Exception{
        preCheck();
        sheet429CoreDao.abortRecentInstances(minutes);
    }

    public static void clearAll() throws Exception{
        preCheck();
        sheet429CoreDao.clearAll();
        sheet429PersonalDao.clearAll();
    }
}
