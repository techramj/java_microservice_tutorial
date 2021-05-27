package com.kale.trade.controller;


import com.kale.trade.entity.Trade;
import com.kale.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @GetMapping("/trade/{id}")
    public Trade getTrade(@PathVariable("id") String id){
        return tradeService.getTrade(id);
    }

    @PostMapping("/trade")
    public Trade addTrade(@RequestBody Trade trade){
        return tradeService.addTrade(trade);
    }
}
