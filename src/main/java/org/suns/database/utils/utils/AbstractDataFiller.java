package org.suns.database.utils.utils;

import org.suns.database.utils.model.AbstractDataModel;

import java.sql.ResultSet;

public abstract class AbstractDataFiller {
    public abstract void fillPersonal(ResultSet resultSet, AbstractDataModel personalModel);
    public abstract void fillCore(ResultSet resultSet, AbstractDataModel coreModel);
}
