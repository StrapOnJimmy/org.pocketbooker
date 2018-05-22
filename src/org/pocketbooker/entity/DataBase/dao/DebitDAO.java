package org.pocketbooker.entity.DataBase.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import org.pocketbooker.entity.model.Debit;

import java.sql.SQLException;
import java.util.List;

public class DebitDAO extends BaseDaoImpl<Debit,Integer> {

    protected DebitDAO(ConnectionSource connectionSource, Class dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
