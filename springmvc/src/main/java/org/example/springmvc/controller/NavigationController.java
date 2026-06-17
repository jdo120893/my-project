package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NavigationController {
    @GetMapping("internal")
    public String internal(Model model) {
        model.addAttribute("data","ForawadData");

//        return "forward:/destination";
        return "redirect:/destination";
    }

    @GetMapping("/destination")
    public String destination(Model model, HttpServletRequest request) {
        String data = (String) model.getAttribute("data");
        String data2 = (String)request.getAttribute("data");
        System.out.println("forward로 받아온 데이터(model) ::"+ data);
        System.out.println("forward로 받아온 데이터(request) ::"+ data2);
        return "welcome";
    }

    @GetMapping("/process")
    public String process(RedirectAttributes redirectAttrs, Model model) {
        model.addAttribute("message","success!");

//        redirectAttrs.addFlashAttribute("message","Success!");
        redirectAttrs.addAttribute("id",123);
        return "redirect:/result?id={id}";
    }

    @GetMapping("/result")
    public String result(@RequestParam("id") int id, Model model){

        System.out.println("id::"+id);
        model.addAttribute("id",id);

        return "result";
    }
}
