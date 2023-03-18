package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {
    
}
