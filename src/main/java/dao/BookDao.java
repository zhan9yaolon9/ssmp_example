package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Book;

import java.util.List;

@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {
    //分页
    //分页查询
    List<Book> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);
   //获取数据总条数
    Long getBookTotal();
}
