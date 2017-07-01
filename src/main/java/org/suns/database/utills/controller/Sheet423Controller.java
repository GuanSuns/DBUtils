package org.suns.database.utills.controller;

import org.suns.database.utills.dao.Sheet423CoreDao;
import org.suns.database.utills.dao.Sheet423PersonalDao;
import org.suns.database.utills.model.Sheet423CoreModel;
import org.suns.database.utills.model.Sheet423PersonalModel;

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
}
