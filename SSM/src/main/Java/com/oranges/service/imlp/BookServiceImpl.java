package com.oranges.service.imlp;

import com.oranges.dao.BookDao;
import com.oranges.domain.Book;
import com.oranges.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public boolean add(Book book) {
        bookDao.add(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }


}
