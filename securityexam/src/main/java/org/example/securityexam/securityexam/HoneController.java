package org.example.securityexam.securityexam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoneController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/info")
    public String info(){
        return "info";
    }

    @GetMapping("/test/t")
    public String test(){
        return "test";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/fail")
    public String fail(){
        return "fail";
    }
}
