package com.oranges.controller;

import com.oranges.domain.Book;
import com.oranges.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public boolean add(@RequestBody Book book) {
        bookService.add(book);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        bookService.delete(id);
        return true;
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        bookService.update(book);
        return true;
    }

    @GetMapping
    public List<Book> selectAll() {
        return bookService.selectAll();
    }

    @GetMapping("/{id}")
    public Book selectById(@PathVariable Integer id) {
        return bookService.selectById(id);
    }


}
