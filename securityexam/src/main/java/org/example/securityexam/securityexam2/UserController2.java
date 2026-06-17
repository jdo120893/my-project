package org.example.securityexam.securityexam2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController2 {

    @GetMapping("/loginForm")
    public String loginForm2(){
        return "loginForm2";
    }
}
