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
    public static boolean addPersonal(Sheet422PersonalModel sheet422PersonalModel){
        if(sheet422PersonalModel == null){
            return false;
        }

        try{
            Sheet422PersonalDao.addInstance(sheet422PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet422CoreModel sheet422CoreModel){
        if(sheet422CoreModel == null){
            return false;
        }

        try{
            Sheet422CoreDao.addInstance(sheet422CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet422PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return Sheet422PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet422CoreModel> getRecentInstancesCore(int days) throws Exception{
        return Sheet422CoreDao.getRecentInstances(days);
    }
}
