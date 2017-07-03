package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet421CoreDao;
import org.suns.database.utils.dao.Sheet421PersonalDao;
import org.suns.database.utils.model.Sheet421CoreModel;
import org.suns.database.utils.model.Sheet421PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet421Controller {
    public static boolean addPersonal(Sheet421PersonalModel sheet421PersonalModel){
        if(sheet421PersonalModel == null){
            return false;
        }

        try{
            Sheet421PersonalDao.addInstance(sheet421PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet421CoreModel sheet421CoreModel){
        if(sheet421CoreModel == null){
            return false;
        }

        try{
            Sheet421CoreDao.addInstance(sheet421CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet421PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return Sheet421PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet421CoreModel> getRecentInstancesCore(int days) throws Exception{
        return Sheet421CoreDao.getRecentInstances(days);
    }
}
