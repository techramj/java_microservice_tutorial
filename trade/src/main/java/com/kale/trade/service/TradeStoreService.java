package com.kale.trade.service;

import com.kale.trade.dao.TradeStoreDao;
import com.kale.trade.entity.TradeStore;
import com.kale.trade.entity.id.TradeStoreUniqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeStoreService {

    @Autowired
    private TradeStoreDao dao;

    public TradeStore addTradeStore(TradeStore store){
        return dao.save(store);
    }

    public TradeStore getTradeStore(TradeStoreUniqueId id){
        return dao.findById(id);
    }

    public List<TradeStore> getTradeStores(){
        return dao.findAll();
    }

}
