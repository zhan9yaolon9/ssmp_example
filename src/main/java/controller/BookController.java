package controller;

import config.R;
import config.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Book;
import service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //使用restful
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //@ApiOperation("获取所有书本数据")
    @GetMapping
    public R getAll(){
        List<Book> bookList = bookService.getAll();
        return new R(true,bookList);
    }

    //@ApiOperation("保存书本数据")
    @PostMapping("save")
    public RestResult saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    //@ApiOperation("更新书本数据")
    @PutMapping("update")
    public RestResult update(@RequestBody Book book){
        return bookService.update(book);
    }

    //@ApiOperation("删除书本数据")
    @DeleteMapping("delete")
    public RestResult delete(@RequestParam("id") int id){
        System.out.println("-------------------"+id+"=======================");
        return bookService.delete(id);
    }

    //@ApiOperation("根据id查询书本")
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        return new R(true,book);
    }

    /**
     * 分页功能 根据pageNow当前页数和pageSize数据的数量
     * @param pageNow
     * @param pageSize
     * @return
     */
    @GetMapping("findByPage")
    public Map<String, Object> findByPage(String pageNow, String pageSize) {
        Map<String, Object> result = new HashMap<>();
        int page = 0;
        int size = 0;
        try {
            page = Integer.parseInt(pageNow);
            size = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //这里我们做一个初始化页面定义，防止空指针错误
        page = page <= 0 ? 1 : page;
        size = size <= 0 ? 4 : size;
        List<Book> books = bookService.findByPage(page, size);
        Long total = bookService.getBookTotal();
        result.put("books", books);
        result.put("total", total);
        return result;
    }
}
