package com.kale.trade.controller;

import com.kale.trade.entity.CounterParty;
import com.kale.trade.service.CounterPartyService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CounterPartyController {

    private CounterPartyService counterPartyService;

    @GetMapping("/counter-party/{id}")
    public CounterParty getCounterParty(@PathVariable("id") String id){
        return counterPartyService.getCounterParty(id);
    }

    @PostMapping("/counter-party")
    public CounterParty addCounterParty(@RequestBody CounterParty cp){
        return counterPartyService.add(cp);
    }
}
