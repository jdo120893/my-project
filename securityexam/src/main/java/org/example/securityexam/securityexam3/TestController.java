package org.example.securityexam.securityexam3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/userinfo")
    public String userinfo(){
        return "user-info";
    }
}