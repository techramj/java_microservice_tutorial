package com.kale.trade.dao;

import com.kale.trade.entity.CounterParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CounterPartDao extends  Dao<CounterParty> {

    @Autowired
    private EntityManager em;

}
