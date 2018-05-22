package org.pocketbooker.entity.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;

public class Funds {

    private BigDecimal sum;
    private Currency currency;

    public Funds(BigDecimal sum, Currency currency) {
        this.sum = sum;
        this.currency = currency;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
