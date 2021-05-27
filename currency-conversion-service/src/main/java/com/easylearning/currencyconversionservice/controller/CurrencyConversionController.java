package com.easylearning.currencyconversionservice.controller;


import com.easylearning.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.easylearning.currencyconversionservice.bean.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;




    @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from") String from,
                                                  @PathVariable("to") String to,
                                                  @PathVariable("quantity") BigDecimal quantity
                                                  ){

        Map<String,String> uriVariables=new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversionBean> responseEntity= new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/USD/to/INR", CurrencyConversionBean.class,uriVariables);

        CurrencyConversionBean response=responseEntity.getBody();


        //return new CurrencyConversionBean(1L,from,to,new BigDecimal(65),null,quantity,port);
        response.setQuantity(quantity);
        response.setTotalCalculatedAmount(quantity.multiply(response.getConversionMultiple()));

        logger.info("From = {}\nTo={}\nquantity={}",from,to,quantity);
        logger.info("Response: {}",response);

        return response;
    }





    @GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyUsingFeign(@PathVariable("from") String from,
                                                  @PathVariable("to") String to,
                                                  @PathVariable("quantity") BigDecimal quantity
    ){



        CurrencyConversionBean response=currencyExchangeServiceProxy.retreiveExchangeValue(from,to);


        response.setQuantity(quantity);
        if(quantity!=null && response.getConversionMultiple()!=null) {
            response.setTotalCalculatedAmount(quantity.multiply(response.getConversionMultiple()));
        }

        logger.info("From = {}\nTo={}\nquantity={}",from,to,quantity);
        logger.info("Response: {}",response);
        return response;
    }



}
