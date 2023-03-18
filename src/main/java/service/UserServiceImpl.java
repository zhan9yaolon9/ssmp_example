package service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import config.RestResult;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    //登录功能
    @Override
    public RestResult login(User user){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("username",user.getUsername());
        User rightUser = userDao.selectOne(qw);
        if(user.getPassword().equals(rightUser.getPassword())){
            return new RestResult(200,rightUser,"成功");
        }
        else{
            return new RestResult(400);
        }
    }
}
