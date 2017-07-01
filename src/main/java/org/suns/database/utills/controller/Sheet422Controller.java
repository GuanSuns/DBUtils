package org.suns.database.utills.controller;

import org.suns.database.utills.dao.Sheet422CoreDao;
import org.suns.database.utills.dao.Sheet422PersonalDao;
import org.suns.database.utills.model.Sheet422CoreModel;
import org.suns.database.utills.model.Sheet422PersonalModel;

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
}
