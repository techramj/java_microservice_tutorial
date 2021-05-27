package com.learnjava.rest.webservice.restfulwebservices.dao.jpa;


import com.learnjava.rest.webservice.restfulwebservices.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {

    //conntection to database
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_person",Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id){
       return entityManager.find(Person.class,id);
    }

    public Person update(Person person){
        Person savePerson = entityManager.merge(person);
        return savePerson;
    }

    public Person delete(int id){
        Person p=findById(id);
        if (p!= null) {
            entityManager.remove(p);
            return p;
        }
        return null;
    }


}
