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
    public static boolean addPersonal(Sheet429PersonalModel sheet429PersonalModel){
        if(sheet429PersonalModel == null){
            return false;
        }

        try{
            Sheet429PersonalDao.addInstance(sheet429PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet429CoreModel sheet429CoreModel){
        if(sheet429CoreModel == null){
            return false;
        }

        try{
            Sheet429CoreDao.addInstance(sheet429CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static ArrayList<Sheet429PersonalModel> getRecentInstancesPersonal(int days) throws Exception{
        return Sheet429PersonalDao.getRecentInstances(days);
    }

    public static ArrayList<Sheet429CoreModel> getRecentInstancesCore(int days) throws Exception{
        return Sheet429CoreDao.getRecentInstances(days);
    }
}
