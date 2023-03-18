package service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import config.RestResult;
import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pojo.Book;
import pojo.User;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public RestResult save(Book book) {
        int i = bookDao.insert(book);
        if(i > 0){
            return new RestResult(200,"增加成功");
        }
        else{
            return new RestResult(400,"增加失败");
        }
    }

    @Override
    public RestResult update(Book book) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("id",book.getId());
        int i = bookDao.update(book,qw);
        if(i > 0){
            return new RestResult(200,"修改成功");
        }
        else{
            return new RestResult(400,"修改失败");
        }
    }

    @Override
    public RestResult delete(int id) {
        int i = bookDao.deleteById(id);
        if(i > 0){
            return new RestResult(200,"删除成功");
        }
        else{
            return new RestResult(400,"删除失败");
        }
    }

    @Cacheable(value="cacheSpace", key="#id") //设置操作的数据是否使用缓存
    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        System.out.println(bookDao);
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }
}
