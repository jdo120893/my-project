package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("name","name");
//        model.addAttribute("message", "Welcome to Spring MVC!");
//        model.addAttribute("timestamp", LocalDateTime.now());
//        return "home";
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "about";
//    }

    @GetMapping("/greeting")
        public String greeting(@RequestParam(defaultValue = "손님") String name, Model model) {
        model.addAttribute("greetingMessage","안녕하세요, ["+name+"]님!");
        return "greeting";
    }
}
