package com.kale.trade.entity;

import com.kale.trade.generator.PrefixGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_seq_generator")
    @GenericGenerator(
            name = "trade_seq_generator",
            strategy = "com.kale.trade.generator.PrefixGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "seq_trade_id"),
                    @Parameter(name = PrefixGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PrefixGenerator.VALUE_PREFIX_PARAMETER, value = "T"),
            })
    private String id;

    @OneToOne
    private Book buyer;

    @OneToOne
    private Book seller;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private String currency;

    @OneToOne
    private Company company;

    public Trade() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBuyer() {
        return buyer;
    }

    public void setBuyer(Book buyer) {
        this.buyer = buyer;
    }

    public Book getSeller() {
        return seller;
    }

    public void setSeller(Book seller) {
        this.seller = seller;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
