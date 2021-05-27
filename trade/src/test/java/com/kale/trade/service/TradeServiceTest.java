package com.kale.trade.service;

import com.kale.trade.dao.TradeDao;
import com.kale.trade.entity.Trade;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TradeServiceTest {

    @Mock
    private TradeDao dao;

    @InjectMocks
    private TradeService service=new TradeService();

    @Test
    void addTrade() {
        when(dao.save(any(Trade.class))).thenReturn(new Trade());
        Trade savedData= service.addTrade(new Trade());
        assertNotNull(savedData);
    }

    @Test
    void getTrade() {
        when(dao.findById(any(String.class))).thenReturn(new Trade());
        Trade searchData=service.getTrade("T1");
        assertNotNull(searchData);
    }
}