package com.kale.trade.dao;

import com.kale.trade.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class BookDao extends Dao<Book>{

    @Autowired
    private EntityManager em;


    /*
    public Book findById(String id){
        return em.find(Book.class, id);
    }

    public Book save(Book book){
        return em.merge(book);
    }

    public List<Book> findAll(){
        TypedQuery<Book> typedQuery=em.createNamedQuery("get_all_book",Book.class);
        return typedQuery.getResultList();
    }

    public void deleteById(String id){
        Book b=findById(id);
        em.remove(b);
    }
    */



}
