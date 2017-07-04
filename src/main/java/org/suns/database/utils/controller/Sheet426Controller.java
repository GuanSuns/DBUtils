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
    public static boolean addPersonal(Sheet426PersonalModel sheet426PersonalModel){
        if(sheet426PersonalModel == null){
            return false;
        }

        try{
            Sheet426PersonalDao.addInstance(sheet426PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet426CoreModel sheet426CoreModel){
        if(sheet426CoreModel == null){
            return false;
        }

        try{
            Sheet426CoreDao.addInstance(sheet426CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet426PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return Sheet426PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet426CoreModel> getRecentInstancesCore(int days) throws Exception{
        return Sheet426CoreDao.getRecentInstances(days);
    }
}
