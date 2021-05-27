package com.easylearning.microservices.limitsservice.controller;

import com.easylearning.microservices.limitsservice.Configuration;
import com.easylearning.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class    LimitsConfigurationController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitConfiguation(){

        return new LimitConfiguration(config.getMinimum()   ,config.getMaximum()    );
    }

}
