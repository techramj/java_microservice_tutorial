package com.kale.trade.service;

import com.kale.trade.dao.CounterPartDao;
import com.kale.trade.entity.CounterParty;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class CounterPartyServiceTest {

    @Mock
    private CounterPartDao dao;

    @InjectMocks
    private CounterPartyService service=new CounterPartyService();

    @Test
    void add() {
        when(dao.save(any(CounterParty.class))).thenReturn(new CounterParty("party1"));
        CounterParty saveData=service.add(new CounterParty());
        assertNotNull(saveData);
    }

    @Test
    void getCounterParty() {
        when(dao.findById(any(String.class))).thenReturn(new CounterParty());
        CounterParty search=service.getCounterParty("CP-1");
        assertNotNull(search);
    }
}