import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.pocketbooker.entity.DataBase.Init;
import org.pocketbooker.entity.DefaultValues;
import org.pocketbooker.entity.model.Credit;
import org.pocketbooker.entity.model.CreditTypes;
import org.pocketbooker.entity.model.Debit;
import org.pocketbooker.entity.model.DebitTypes;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        Init.init();

        ConnectionSource connectionSource = new JdbcConnectionSource(DefaultValues.connectionSource);
        Dao<Credit, Integer> creditDao = DaoManager.createDao(connectionSource, Credit.class);
        Dao<CreditTypes, Integer> creditTypesDao = DaoManager.createDao(connectionSource, CreditTypes.class);

        List<CreditTypes> creditTypesList = creditTypesDao.queryForAll();

        for (CreditTypes type : creditTypesList
                ) {
            creditDao.create(new Credit(Date.valueOf(LocalDate.now()), new BigDecimal(1500), Currency.getInstance("RUB").toString(), type));
        }

        Dao<Debit, Integer> debitDao = DaoManager.createDao(connectionSource, Debit.class);
        Dao<DebitTypes, Integer> debitTypesDao = DaoManager.createDao(connectionSource, DebitTypes.class);

        List<DebitTypes> debitTypesList = debitTypesDao.queryForAll();

        for (DebitTypes type : debitTypesList
                ) {
            debitDao.create(new Debit(Date.valueOf(LocalDate.now()), new BigDecimal(100000), Currency.getInstance("RUB").toString(), type));
        }



        List<Credit> creditList = creditDao.queryForAll();

        for (Credit item : creditList
                ) {
            System.out.println("ID = " + item.getId());
            System.out.println("Date = " + item.getDateTime());
            System.out.println("Sum = " + item.getSum());
            item.setSum(new BigDecimal(50000));
            creditDao.update(item);
            System.out.println("Currency = " + item.getCurrency());
            item.setCurrency(Currency.getInstance("USD").toString());
            creditDao.update(item);
            System.out.println("Credit type = " + item.getTypeName());
//            creditDao.deleteById(item.getId());
            System.out.println("====================DELETED=========================");
        }

        long totalTime = System.currentTimeMillis() - startTime;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(totalTime);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:SS");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

}
