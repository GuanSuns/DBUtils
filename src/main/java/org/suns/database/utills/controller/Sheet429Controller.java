package org.suns.database.utills.controller;

import org.suns.database.utills.dao.Sheet429CoreDao;
import org.suns.database.utills.dao.Sheet429PersonalDao;
import org.suns.database.utills.model.Sheet429CoreModel;
import org.suns.database.utills.model.Sheet429PersonalModel;

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
}
