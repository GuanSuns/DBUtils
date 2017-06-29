package org.suns.controller;

import org.suns.dao.Sheet411CoreDao;
import org.suns.dao.Sheet411PersonalDao;
import org.suns.dao.Sheet421CoreDao;
import org.suns.dao.Sheet421PersonalDao;
import org.suns.model.Sheet411CoreModel;
import org.suns.model.Sheet411PersonalModel;
import org.suns.model.Sheet421CoreModel;
import org.suns.model.Sheet421PersonalModel;

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
}
