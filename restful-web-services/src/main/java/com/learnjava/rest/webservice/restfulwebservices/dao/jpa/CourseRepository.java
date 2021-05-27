package com.learnjava.rest.webservice.restfulwebservices.dao.jpa;


import com.learnjava.rest.webservice.restfulwebservices.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CourseRepository {

    @Autowired
    private EntityManager em;

    public List<Course> findAll(){

        TypedQuery<Course> typedQuery=em.createNamedQuery("get_all_course",Course.class);
        return typedQuery.getResultList();
    }

    public Course findById(long id){
        return em.find(Course.class,id);
    }

    public Course save(Course course){
        if(course.getId()==null){
            em.persist(course);
        }else{
             em.merge(course);
        }
        return course;
    }

    public void deleteById(long id){
        Course c=findById(id);
        em.remove(c);
    }

    public List<Course> getAllJavaCourse(){
        TypedQuery<Course> typeQuery = em.createNamedQuery("get_all_java_course", Course.class);
        return typeQuery.getResultList();
    }

    public void demo1(){
        Query query = em.createQuery("Select c from Course c where c.name=:name");
        Query query1 = query.setParameter("name", "Java");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);

    }

    



}
