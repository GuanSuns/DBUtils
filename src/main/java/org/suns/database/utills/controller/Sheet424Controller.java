package org.suns.database.utills.controller;

import org.suns.database.utills.dao.Sheet424CoreDao;
import org.suns.database.utills.dao.Sheet424PersonalDao;
import org.suns.database.utills.model.Sheet424CoreModel;
import org.suns.database.utills.model.Sheet424PersonalModel;

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
}
