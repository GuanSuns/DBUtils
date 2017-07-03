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
    public static boolean addPersonal(Sheet424PersonalModel sheet424PersonalModel){
        if(sheet424PersonalModel == null){
            return false;
        }

        try{
            Sheet424PersonalDao.addInstance(sheet424PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet424CoreModel sheet424CoreModel){
        if(sheet424CoreModel == null){
            return false;
        }

        try{
            Sheet424CoreDao.addInstance(sheet424CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet424PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return Sheet424PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet424CoreModel> getRecentInstancesCore(int days) throws Exception{
        return Sheet424CoreDao.getRecentInstances(days);
    }
}
