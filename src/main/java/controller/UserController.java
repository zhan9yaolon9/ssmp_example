package controller;

import config.ApiJson;
import config.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/loginjwt")
    public ApiJson loginjwt(@RequestBody User user) {
        return userService.loginjwt(user);
    }
}
