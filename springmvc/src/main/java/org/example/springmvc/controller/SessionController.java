package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes({"visitCount","cart","loginUser"})
public class SessionController {
    @ModelAttribute("visitCount")
    public int getVisitCount(){
        return 0;
    }

    @ModelAttribute("cart")
    public ArrayList getCart(){
        return new ArrayList<>();
    }

    @ModelAttribute("loginUser")
    public User getLoginUser() {
        return new User();
    }
    @GetMapping("/visit")
    public String visitPage(@ModelAttribute(name="visitCount")int visitCount, Model model) {
        visitCount++;
        model.addAttribute("visitCount", visitCount);

        return "visit";
    }
    //    상태정보로 유지하고 싶은 값을 받아오는 화면 요청
    @GetMapping("/sessionForm")
    public String sessionForm() {
        return "session_form";
    }

    @GetMapping("/addSession")
    public String addSession(@RequestParam("sessionKey") String sessionKey,
                             @RequestParam("sessionValue")String sessionValue,
                             HttpSession session) {

        session.setAttribute(sessionKey, sessionValue);
        return  "redirect:/sessionView";
    }
    @GetMapping("/sessionView")
    public String sessionView(HttpSession session, Model model) {

//        세션이 저장한 모든 값을 출력한다라고 하면..
        Map<String, Object> map = new HashMap<String, Object>();

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = session.getAttribute(attributeName);
            map.put(attributeName, attributeValue);
        }

        model.addAttribute("session", map);
//        System.out.println(map.size());
        return "session_view";
    }

    @GetMapping("/sessionDel")
    public String sessionDel(@RequestParam("sessionKey") String sessionKey, HttpSession session) {
        session.removeAttribute(sessionKey);

        session.invalidate();
        return "redirect:/sessionView";
    }

    @GetMapping("/listView")
    public String listaView(HttpSession session, Model mode) {
        Object attribute = session.getAttribute("login");
        if (attribute != null) {
            return "welcome";
        } else {
            return "redirect:/sessionForm";
        }
    }

    @GetMapping("/listView2")
    public String listaView2(@SessionAttribute(name="login", required = false) Object attribute) {

        if (attribute != null) {
            return "welcome";
        } else {
            return "redirect:/sessionForm";
        }
    }
}