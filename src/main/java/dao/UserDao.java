package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pojo.User;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
