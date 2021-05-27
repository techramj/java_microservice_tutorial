package com.kale.trade.service;

import com.kale.trade.dao.BookDao;
import com.kale.trade.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceTest {

    @Mock
    private BookDao dao;

    @InjectMocks
    private BookService bookService=new BookService();

    @BeforeEach
    void beforeSetup(){

    }


    @Test
    void addBook() {
        Book b=new Book("book1");
        b.setId("B1");
        when(dao.save(any(Book.class))).thenReturn(b);

        Book savedBook= bookService.addBook(new Book());
        assertNotNull(savedBook);

    }

    @Test
    void deleteBook() {
        doNothing().when(dao).deleteById(any(String.class));
        bookService.deleteBook("B1");
        verify(dao,times(1)).deleteById("B1");
    }

    @Test
    void updateBook() {
        Book b=new Book("book1");
        b.setId("B1");
        when(dao.save(any(Book.class))).thenReturn(b);

        Book updatedBook= bookService.updateBook(b);
        assertNotNull(updatedBook);

    }

    @Test
    void getBook() {
        Book b=new Book("book1");
        b.setId("B1");
        when(dao.findById(any(String.class))).thenReturn(b);

        Book bookSearch= bookService.getBook("B1");
        assertNotNull(bookSearch);
        verify(dao,times(1)).findById("B1");
    }
}