package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet423CoreDao;
import org.suns.database.utils.dao.Sheet423PersonalDao;
import org.suns.database.utils.model.Sheet423CoreModel;
import org.suns.database.utils.model.Sheet423PersonalModel;

import java.util.ArrayList;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet423Controller {
    public static boolean addPersonal(Sheet423PersonalModel sheet423PersonalModel){
        if(sheet423PersonalModel == null){
            return false;
        }

        try{
            Sheet423PersonalDao.addInstance(sheet423PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet423CoreModel sheet423CoreModel){
        if(sheet423CoreModel == null){
            return false;
        }

        try{
            Sheet423CoreDao.addInstance(sheet423CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet423PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return Sheet423PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet423CoreModel> getRecentInstancesCore(int days) throws Exception{
        return Sheet423CoreDao.getRecentInstances(days);
    }
}
