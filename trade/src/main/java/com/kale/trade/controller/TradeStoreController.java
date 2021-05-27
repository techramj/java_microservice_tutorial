package com.kale.trade.controller;

import com.kale.trade.entity.TradeStore;
import com.kale.trade.entity.id.TradeStoreUniqueId;
import com.kale.trade.service.TradeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeStoreController  {

    @Autowired
    private TradeStoreService tradeStoreService;

    @PostMapping("/trade-store")
    public TradeStore addStore(@RequestBody TradeStore store){
        return tradeStoreService.addTradeStore(store);
    }

    @PostMapping("/trade-store/id")
    public TradeStore getTradeStore(@RequestBody TradeStoreUniqueId id){
        return tradeStoreService.getTradeStore(id);
    }

    @GetMapping("/trade-store")
    public List<TradeStore> getTradeStoreS(){
        return tradeStoreService.getTradeStores();
    }


}
