package com.learnjava.rest.webservice.restfulwebservices.controller;


import com.learnjava.rest.webservice.restfulwebservices.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(path = "/test")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping(value = "/greet")
    public String greet(){

        return "Hello World";
    }

    @GetMapping(value="greet/{name}")
    public String greet(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @GetMapping(value = "/greet-bean")
    public HelloWorldBean greetHelloBean(){
        return new HelloWorldBean("hello bean");
    }

    @GetMapping(value="greet-in18/{name}")
    public String greetInternalization(@PathVariable("name") String name,@RequestHeader(value = "Accept-Language", required = false) Locale locale){
        System.out.println(locale);
        String s= messageSource.getMessage("good.morning.message", null, locale);
        System.out.println("Message is: +"+s);
        return s;
    }

}
