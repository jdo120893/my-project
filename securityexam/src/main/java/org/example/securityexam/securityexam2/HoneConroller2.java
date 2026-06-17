package org.example.securityexam.securityexam2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoneConroller2 {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/info2")
        public String info2(){
        return "info2";
        }

    @GetMapping("/test2/t2")
    public String test(){
        return "test";
    }

    @GetMapping("/hello2")
    public String hello(){
        return "hello";
    }

    @GetMapping("/fail2")
    public String fail(){
        return "fail";
    }
}
