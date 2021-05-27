package com.kale.trade.service;

import com.kale.trade.dao.CounterPartDao;
import com.kale.trade.entity.CounterParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterPartyService {

    @Autowired
    private CounterPartDao dao;

    public CounterParty add(CounterParty cp){
        return dao.save(cp);
    }

    public CounterParty getCounterParty(String id){
        return dao.findById(id);
    }

}
