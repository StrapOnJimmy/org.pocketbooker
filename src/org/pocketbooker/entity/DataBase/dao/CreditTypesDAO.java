package org.pocketbooker.entity.DataBase.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import org.pocketbooker.entity.model.CreditTypes;

import java.sql.SQLException;

public class CreditTypesDAO extends BaseDaoImpl<CreditTypes,Integer> {

    protected CreditTypesDAO(ConnectionSource connectionSource, Class<CreditTypes> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
