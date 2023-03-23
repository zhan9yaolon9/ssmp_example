package service;

import config.ApiJson;
import config.RestResult;
import pojo.User;

public interface UserService {
    RestResult login(User user);

    ApiJson loginjwt(User user);
    User selectUserById(String id);

}
