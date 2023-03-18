package service;

import config.RestResult;
import pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    RestResult login(User user);
}
