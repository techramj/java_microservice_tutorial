package com.kale.trade.dao;

import com.kale.trade.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CompanyDao extends Dao<Company> {

    @Autowired
    private EntityManager em;

    /*
    public Company findById(String id){
        return em.find(Company.class,id);
    }

    public Company save(Company company){
        return em.merge(company);
    }

    public List<Company> findAll(){
        TypedQuery<Company> query=em.createNamedQuery("get_all_company", Company.class);
        return query.getResultList();
    }
    */



}
