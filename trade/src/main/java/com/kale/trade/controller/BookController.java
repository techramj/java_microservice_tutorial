package com.kale.trade.controller;

import com.kale.trade.entity.Book;
import com.kale.trade.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("book/{id}")
    public Book getBook(@PathVariable("id") String id){
        return bookService.getBook(id);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

}
