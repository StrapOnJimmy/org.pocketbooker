package org.pocketbooker.entity.DataBase;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.pocketbooker.entity.model.Credit;
import org.pocketbooker.entity.model.CreditTypes;
import org.pocketbooker.entity.model.Debit;
import org.pocketbooker.entity.model.DebitTypes;

import java.sql.SQLException;
import java.util.List;

public class Init {

    public static void init() throws SQLException{

        String DATABASE_URL = "jdbc:sqlite:pocketbooker.db";
        ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);

        TableUtils.createTableIfNotExists(connectionSource, Credit.class);
        TableUtils.createTableIfNotExists(connectionSource, Debit.class);
        TableUtils.createTableIfNotExists(connectionSource, DebitTypes.class);
        TableUtils.createTableIfNotExists(connectionSource, CreditTypes.class);

        populateDebitTypes(connectionSource);
        populateCreditTypes(connectionSource);

    }

    private static void populateDebitTypes(ConnectionSource connectionSource) throws SQLException {
        Dao<DebitTypes,Integer> debitTypesDao = DaoManager.createDao(connectionSource, DebitTypes.class);

        List<DebitTypes> debitTypesList = debitTypesDao.queryForAll();

        if (debitTypesList == null || debitTypesList.isEmpty()){
            debitTypesDao.create(new DebitTypes(1,"Зарплата"));
            debitTypesDao.create(new DebitTypes(2,"Аванс"));
            debitTypesDao.create(new DebitTypes(3,"Одолжил в долг"));
        }
    }

    private static void populateCreditTypes(ConnectionSource connectionSource) throws SQLException{
        Dao<CreditTypes, Integer> creditTypesDao = DaoManager.createDao(connectionSource, CreditTypes.class);

        List<CreditTypes> creditTypesList = creditTypesDao.queryForAll();

        if (creditTypesList == null || creditTypesList.isEmpty()){
            creditTypesDao.create(new CreditTypes("Покупки"));
            creditTypesDao.create(new CreditTypes("Коммунальные платежи"));
            creditTypesDao.create(new CreditTypes("Кино"));
        }
    }


}
