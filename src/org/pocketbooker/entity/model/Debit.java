package org.pocketbooker.entity.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@DatabaseTable(tableName = "Debit")
public class Debit {
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

    public Debit() {
    }

    public Debit(Date dateTime, BigDecimal sum, String currency, DebitTypes debitTypes) {
        this.dateTime = dateTime;
        this.sum = sum;
        this.currency = currency;
        this.TypeName = debitTypes.getName();
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
        DebitTypes debitType = new DebitTypes();
        debitType.setName(typeName);
        this.TypeName = debitType.getName();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debit debit = (Debit) o;
        return Objects.equals(id, debit.id) &&
                Objects.equals(dateTime, debit.dateTime) &&
                Objects.equals(sum, debit.sum) &&
                Objects.equals(currency, debit.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, sum, currency);
    }
}