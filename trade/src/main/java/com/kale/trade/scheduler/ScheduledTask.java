package com.kale.trade.scheduler;

import com.kale.trade.dao.TradeStoreDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    private TradeStoreDao tradeStoreDao;

    @Scheduled(fixedRate = 5000)  //every five second
    //@Scheduled(cron = "0 0 0 * * *")  //daily
    public void updateExpiryDate(){
        log.info("updateExpiryDateCorn");

    }


}
