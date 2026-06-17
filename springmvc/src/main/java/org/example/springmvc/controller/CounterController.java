package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {

    @GetMapping("/counter")
    public String counter(@CookieValue(value = "visitCount", defaultValue = "0")
                          int visitCount,
                          HttpServletResponse response,
                          Model model){

        visitCount++;

        Cookie cookie = new Cookie("visitCount", String.valueOf(visitCount));
        cookie.setMaxAge(365*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("visitCount",visitCount);

        return "counter";
    }

    @GetMapping("/counter/reset")
    public String resetCounter(HttpServletResponse response) {

        Cookie cookie = new Cookie("visitCount",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/counter";
    }
}
