package service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import config.RestResult;
import org.apache.ibatis.annotations.Mapper;
import pojo.Book;

import java.util.List;


public interface BookService {
    RestResult save(Book book);
    RestResult update(Book book);
    RestResult delete(int id);
    public Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
