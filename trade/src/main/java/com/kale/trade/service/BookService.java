package com.kale.trade.service;

import com.kale.trade.dao.BookDao;
import com.kale.trade.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book addBook(Book book){
        return bookDao.save(book);
    }

    public void deleteBook(String bookId){
        bookDao.deleteById(bookId);
    }

    public Book updateBook(Book book){
        return bookDao.save(book);
    }

    public Book getBook(String id){
        return bookDao.findById(id);
    }




}
