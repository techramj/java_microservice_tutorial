package com.kale.trade.service;

import com.kale.trade.dao.TradeDao;
import com.kale.trade.entity.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    @Autowired
    private TradeDao dao;

    public Trade addTrade(Trade trade){
        return dao.save(trade);
    }

    public Trade getTrade(String tradeId){
        return dao.findById(tradeId);
    }
}
