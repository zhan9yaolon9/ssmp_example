package controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import config.R;
import config.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Book;
import service.BookService;

import java.util.List;

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
    public RestResult save(@RequestBody Book book){
        return bookService.save(book);
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

   // @ApiOperation("页数？")
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage,pageSize);
        return new R(true,page);
    }

}
