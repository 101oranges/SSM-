package com.oranges.dao;

import com.oranges.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookDao {

    @Insert("insert into test_table (type,name,description) values(#{type},#{name},#{description}) ")
    public void add(Book book);
    @Delete("delete from test_table where id = #{id}}")
    public void delete(Integer id);
    @Update("update test_table set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public void update(Book book);
    @Select("select * from test_table")
    public List<Book> selectAll();
    @Select("select * from test_table where id = #{id}")
    public Book selectById(Integer id);


}
