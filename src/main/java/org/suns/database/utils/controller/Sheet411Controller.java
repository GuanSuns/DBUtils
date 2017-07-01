package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet411CoreDao;
import org.suns.database.utils.dao.Sheet411PersonalDao;
import org.suns.database.utils.model.Sheet411CoreModel;
import org.suns.database.utils.model.Sheet411PersonalModel;

/**
 * Created by guanl on 6/29/2017.
 */
public class Sheet411Controller {
    public static boolean addPersonal(Sheet411PersonalModel sheet411PersonalModel){
        if(sheet411PersonalModel == null){
            return false;
        }

        try{
            Sheet411PersonalDao.addInstance(sheet411PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet411CoreModel sheet411CoreModel){
        if(sheet411CoreModel == null){
            return false;
        }

        try{
            Sheet411CoreDao.addInstance(sheet411CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
