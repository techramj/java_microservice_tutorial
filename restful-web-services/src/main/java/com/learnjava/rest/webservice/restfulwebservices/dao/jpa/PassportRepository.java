package com.learnjava.rest.webservice.restfulwebservices.dao.jpa;


import com.learnjava.rest.webservice.restfulwebservices.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PassportRepository {

    @Autowired
    private EntityManager em;

    public List<Passport> findAll(){
        TypedQuery<Passport> get_all_student = em.createNamedQuery("get_all_passport", Passport.class);
        return get_all_student.getResultList();
    }

    public Passport findById(Long id){
        return em.find(Passport.class,id);
    }

    public Passport save(Passport passport){
        if(passport.getId()==null){
            em.persist(passport);
        }else{
            em.merge(passport);
        }
        return passport;
    }

    public void deleteById(Long id){
        Passport passport=findById(id);
        em.remove(passport);
    }

}
