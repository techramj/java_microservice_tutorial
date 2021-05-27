package com.easylearning.currencyconversionservice;

import com.easylearning.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="current-exchange-service", url="localhost:8000")
//@FeignClient(name="current-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@LoadBalancerClient(name ="current-exchange-service" )
public interface CurrencyExchangeServiceProxy {

    //@GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/current-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retreiveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);


}
