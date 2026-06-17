package org.example.iocexam.controller;

import org.example.iocexam.domain.User;
import org.example.iocexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    
    public UserController(UserService userService){
        this.userService = userService;
        System.out.println("UserController 생성");
    }
    public void joinUser(){
        User user = new User();
        user.setName("carami");
        user.setPassword("123456");
        user.setEmail("carami@gmail.com");

        userService.joinUser(user);
    }
}
