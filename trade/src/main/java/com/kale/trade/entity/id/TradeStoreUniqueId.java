package com.kale.trade.entity.id;

import java.io.Serializable;

public class TradeStoreUniqueId implements Serializable {

    private String tradeId;
    private String counterPartyId;
    private String bookId;

    public TradeStoreUniqueId() {
    }

    public TradeStoreUniqueId(String tradeId, String counterPartyId, String bookId) {
        this.tradeId = tradeId;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
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
}
