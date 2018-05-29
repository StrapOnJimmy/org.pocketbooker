package org.pocketbooker.entity.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@DatabaseTable(tableName = "Credit")
public class Credit {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private Date dateTime;
    @DatabaseField(canBeNull = false)
    private BigDecimal sum;
    @DatabaseField(canBeNull = false)
    private String currency;
    @DatabaseField(canBeNull = false)
    private String TypeName;

    public Credit() {
    }

    public Credit(Date dateTime, BigDecimal sum, String currency, CreditTypes TypeName) {
        this.dateTime = dateTime;
        this.sum = sum;
        this.currency = currency;
        this.TypeName = TypeName.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        CreditTypes creditType = new CreditTypes();
        creditType.setName(typeName);
        this.TypeName = creditType.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) &&
                Objects.equals(dateTime, credit.dateTime) &&
                Objects.equals(sum, credit.sum) &&
                Objects.equals(currency, credit.currency);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dateTime, sum, currency);
    }
}
