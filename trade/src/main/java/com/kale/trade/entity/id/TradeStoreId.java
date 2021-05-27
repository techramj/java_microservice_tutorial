package com.kale.trade.entity.id;

import com.kale.trade.entity.Book;
import com.kale.trade.entity.CounterParty;
import com.kale.trade.entity.Trade;

import java.io.Serializable;

public class TradeStoreId implements Serializable {

    private Trade trade;
    private CounterParty counterParty;
    private Book bookDetail;

    public TradeStoreId() {
    }


    public TradeStoreId(Trade trade, CounterParty counterParty, Book bookDetail) {
        this.trade = trade;
        this.counterParty = counterParty;
        this.bookDetail = bookDetail;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public CounterParty getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(CounterParty counterParty) {
        this.counterParty = counterParty;
    }

    public Book getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(Book bookDetail) {
        this.bookDetail = bookDetail;
    }


}

