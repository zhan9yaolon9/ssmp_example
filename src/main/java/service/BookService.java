package service;

import com.baomidou.mybatisplus.extension.service.IService;
import config.RestResult;
import pojo.Book;

import java.util.List;


public interface BookService extends IService<Book> {
    RestResult saveBook(Book book);
    RestResult update(Book book);
    RestResult delete(int id);
    public Book getById(Integer id);
    List<Book> getAll();
    List<Book> findByPage(Integer start, Integer rows);
    Long getBookTotal();
}
