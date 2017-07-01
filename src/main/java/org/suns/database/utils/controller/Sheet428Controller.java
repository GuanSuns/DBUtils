package org.suns.database.utils.controller;

import org.suns.database.utils.dao.Sheet428CoreDao;
import org.suns.database.utils.dao.Sheet428PersonalDao;
import org.suns.database.utils.model.Sheet428CoreModel;
import org.suns.database.utils.model.Sheet428PersonalModel;

/**
 * Created by guanl on 6/30/2017.
 */
public class Sheet428Controller {
    public static boolean addPersonal(Sheet428PersonalModel sheet428PersonalModel){
        if(sheet428PersonalModel == null){
            return false;
        }

        try{
            Sheet428PersonalDao.addInstance(sheet428PersonalModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean addCore(Sheet428CoreModel sheet428CoreModel){
        if(sheet428CoreModel == null){
            return false;
        }

        try{
            Sheet428CoreDao.addInstance(sheet428CoreModel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
