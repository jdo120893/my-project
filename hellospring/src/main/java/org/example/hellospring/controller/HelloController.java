package org.example.hellospring.controller;

import org.example.hellospring.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
//    @PostMapping
//    @PutMapping
//    @PatchMapping
//    @GetMapping
//    @DeleteMapping

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @GetMapping("/user")
    public  User getUser(){
        //값을 DB에서 꺼낼 수도 있을거고.. 등등 얻어 올 수 있을 거예요.
        User user = new User();
        user.setUsername("test");
        user.setPassword("1234");
        user.setPhone("010-1111-2222");
        user.setEmail("catami@gmail.com");

        return user;
    }
}
