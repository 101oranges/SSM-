package com.oranges.service;

import com.oranges.domain.Book;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
public interface BookService {

    public boolean add(Book book);

    public boolean delete(Integer id);

    public boolean update(Book book);

    public List<Book> selectAll();

    public Book selectById(Integer id);

}
