package service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import config.ApiJson;
import config.JwtConfigProperties;
import config.RestResult;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import pojo.User;
import utils.JWTUtil;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtConfigProperties jwtConfigProperties;
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

    /**
     * 使用jwt验证，使用postman时使用json
     * @param user
     * @return
     */
    @PostMapping("/loginjwt")
    public ApiJson loginjwt(User user){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("username",user.getUsername());
        User rightUser = userDao.selectOne(qw);
        if(user.getPassword().equals(rightUser.getPassword())){
            // 登录成功，返回token
            return ApiJson.ok("登录成功", JWTUtil.sign(user.getUsername(), jwtConfigProperties));
        }else{
            return ApiJson.error("登录失败");
        }
    }

    @Override
    public User selectUserById(String id){
        return userDao.selectById(id);
    }
}
