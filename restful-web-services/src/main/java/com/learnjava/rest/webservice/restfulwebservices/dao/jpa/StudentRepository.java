package com.learnjava.rest.webservice.restfulwebservices.dao.jpa;


import com.learnjava.rest.webservice.restfulwebservices.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentRepository {

    @Autowired
    private EntityManager em;

    public List<Student> findAll(){
        TypedQuery<Student> get_all_student = em.createNamedQuery("get_all_student", Student.class);
        return get_all_student.getResultList();
    }

    public Student findById(Long id){
        return em.find(Student.class,id);
    }

    public Student save(Student student){
        if(student.getId()==null){
            em.persist(student);
        }else{
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id){
        Student student=findById(id);
        em.remove(student);
    }




}
