package controller;

import config.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import service.UserService;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public RestResult login(@RequestBody User user){
        return userService.login(user);
    }



}
