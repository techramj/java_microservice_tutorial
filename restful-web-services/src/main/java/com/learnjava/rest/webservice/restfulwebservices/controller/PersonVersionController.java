package com.learnjava.rest.webservice.restfulwebservices.controller;

import com.learnjava.rest.webservice.restfulwebservices.bean.Name;
import com.learnjava.rest.webservice.restfulwebservices.bean.PersonV1;
import com.learnjava.rest.webservice.restfulwebservices.bean.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    @GetMapping("/person/v1")
    public PersonV1 getNameV1(){
        return new PersonV1("Ram Jaiswal");
    }

    @GetMapping("/person/v2")
    public PersonV2 getNameV2(){
        return new PersonV2(new Name("Ram","Jaiswal"));
    }


    @GetMapping(value = "/person/param", params = "v1")
    public PersonV1 getNameV1Param(){
        return new PersonV1("Ram Jaiswal");
    }

    @GetMapping(value = "/person/param", params = "v2")
    public PersonV2 getNameV2Param(){
        return new PersonV2(new Name("Ram","Jaiswal"));
    }


    @GetMapping(value = "/person/header", headers = "X_VERSION-API=v1")
    public PersonV1 getNameV1Header(){
        return new PersonV1("Ram Jaiswal");
    }

    @GetMapping(value = "/person/header", headers = "X_VERSION-API=v2")
    public PersonV2 getNameV2Header(){
        return new PersonV2(new Name("Ram","Jaiswal"));
    }


    @GetMapping(value = "/person/producer", produces = "application/api-v1+json")
    public PersonV1 getNameV1Producer(){
        return new PersonV1("Ram Jaiswal");
    }

    @GetMapping(value = "/person/producer", produces = "application/api-v2+json")
    public PersonV2 getNameV2Producer(){
        return new PersonV2(new Name("Ram","Jaiswal"));
    }



}
