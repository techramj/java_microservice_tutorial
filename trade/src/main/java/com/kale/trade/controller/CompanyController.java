package com.kale.trade.controller;


import com.kale.trade.entity.Company;
import com.kale.trade.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/company")
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @GetMapping("/company/{id}")
    public Company getCompany(@PathVariable("id") String companyId){
        return companyService.getCompany(companyId);
    }
}
