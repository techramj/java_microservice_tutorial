package com.kale.trade.service;

import com.kale.trade.dao.TradeStoreDao;
import com.kale.trade.entity.TradeStore;
import com.kale.trade.entity.id.TradeStoreUniqueId;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TradeStoreServiceTest {

    @Mock
    private TradeStoreDao dao;

    @InjectMocks
    private TradeStoreService service=new TradeStoreService();

    @Test
    void addTradeStore() {
        when(dao.save(any(TradeStore.class))).thenReturn(new TradeStore());
        TradeStore savedStore=service.addTradeStore(new TradeStore());
        assertNotNull(savedStore);
    }

    @Test
    void getTradeStore() {
        when(dao.findById(any(TradeStoreUniqueId.class))).thenReturn(new TradeStore());
        TradeStore searchData=service.getTradeStore(new TradeStoreUniqueId());
        assertNotNull(searchData);
    }

    @Test
    void getTradeStores() {
        List<TradeStore> list= Arrays.asList(new TradeStore(), new TradeStore());
        when(dao.findAll()).thenReturn(list);

        List<TradeStore> stores=service.getTradeStores();
        assertNotNull(stores);
        assertEquals(2,stores.size());
    }
}