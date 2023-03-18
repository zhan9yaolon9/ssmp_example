package controller;

import config.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpSession;

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
