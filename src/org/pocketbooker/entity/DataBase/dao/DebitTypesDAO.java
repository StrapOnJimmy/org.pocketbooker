package org.pocketbooker.entity.DataBase.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import org.pocketbooker.entity.model.DebitTypes;

import java.sql.SQLException;

public class DebitTypesDAO extends BaseDaoImpl<DebitTypes,Integer>{

    protected DebitTypesDAO(ConnectionSource connectionSource, Class<DebitTypes> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
