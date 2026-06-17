package org.example.springmvc.controller;

import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvc.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
@Slf4j
public class itemController {
    @GetMapping("/item")
        public String item(){
        return "item/item_form.html";
    }

    @PostMapping("/item")
    public String item2(@ModelAttribute Item item){
        log.info("name:{}",item.getName());
        log.info("price:{}",item.getPrice());
        return "redirect:/hi";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Item> items = Arrays.asList(
                new Item("사과", 2000),
                new Item("오렌지", 4000),
                new Item("망고", 5000),
                new Item("수박", 6000)
        );

        model.addAttribute("items",items);
        return "item/list";
    }

}
