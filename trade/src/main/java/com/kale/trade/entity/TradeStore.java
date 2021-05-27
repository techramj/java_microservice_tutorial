package com.kale.trade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kale.trade.entity.id.TradeStoreUniqueId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity
@IdClass(TradeStoreUniqueId.class)
public class TradeStore {

    @Id
    private String tradeId;

    @Id
    private String counterPartyId;

    @Id
    private String bookId;

    private Long serialNo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date maturityDate;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private Date createdDate;

    private char expired;

    public TradeStore() {
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public char getExpired() {
        return expired;
    }

    public void setExpired(char expired) {
        this.expired = expired;
    }
}
