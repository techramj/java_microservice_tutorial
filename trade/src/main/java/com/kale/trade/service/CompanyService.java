package com.kale.trade.service;

import com.kale.trade.dao.CompanyDao;
import com.kale.trade.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public Company addCompany(Company company){
        return companyDao.save(company);
    }

    public Company updateCompany(Company company){
        return companyDao.save(company);
    }

    public void deleteCompany(String id){
        companyDao.deleteById(id);
    }

    public Company getCompany(String id){
        return companyDao.findById(id);
    }
}
