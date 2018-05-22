package org.pocketbooker.entity.DataBase.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import org.pocketbooker.entity.model.Credit;

import java.sql.SQLException;
import java.util.List;

public class CreditDAO extends BaseDaoImpl<Credit, Integer> {

    protected CreditDAO(ConnectionSource connectionSource, Class<Credit> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    @Override
    public List<Credit> queryForAll() throws SQLException {
        return super.queryForAll();
    }
}
