package org.example.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class CaramiController {
    @GetMapping("/hi2")
    public String hi(){
        return "welcome";
    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "name",required = false,defaultValue = "guest") String name,
                        @RequestParam("message") String message, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping("/index2")
    public ModelAndView index2(@RequestParam(name = "name",required = false,defaultValue = "guest") String name,
                               @RequestParam("message") String message){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", name);
        mv.addObject("message", message);

        return mv;
    }

    @GetMapping("/index3/{newsid}")
    public String index3(@PathVariable("newsid") String id){
       log.info("newsid::"+id);

        return "welcome";
    }
}
