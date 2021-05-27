package com.kale.trade.dao;

import com.kale.trade.TradeApplication;
import com.kale.trade.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TradeApplication.class)
@SpringBootTest
class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void findById() {
        System.out.println(bookDao);
        System.out.println(bookDao.getEntityManager());

         Book book=bookDao.findById("B1");
       // System.out.println(book);
    }

    @Test
    void findAll() {
    }

    @DirtiesContext
    @Test
    @Transactional
    void save() {
        Book book=new Book("Book_Test5");
        Book savedBook=bookDao.save(book);
        assertNotNull(savedBook);
        assertNotNull(savedBook.getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    void deleteById() {
        bookDao.deleteById("B99999");
    }

    @Test
    @Transactional
    @DirtiesContext
    void deleteByIdTestForInvalidId(){
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,()->{bookDao.deleteById("9999");});
    }
}