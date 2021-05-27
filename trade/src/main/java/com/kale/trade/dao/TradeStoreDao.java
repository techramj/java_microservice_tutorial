package com.kale.trade.dao;

import com.kale.trade.entity.TradeStore;
import com.kale.trade.entity.id.TradeStoreUniqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TradeStoreDao extends Dao<TradeStore>{

    @Autowired
    private EntityManager em;

    public TradeStore findById(TradeStoreUniqueId id){
        return  em.find(TradeStore.class,id);
    }

}
