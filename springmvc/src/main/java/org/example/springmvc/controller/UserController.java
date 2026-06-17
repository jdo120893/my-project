package org.example.springmvc.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/form")
    public String joinForm() {
        return "user_join_form";
    }

    @GetMapping("/join")
    public String join(Model model){
        //회원가입 폼을 응답.
        model.addAttribute("user", new User());

        return "user/user_join_form";
    }
    @PostMapping("/join")
    public String join2(@Valid @ModelAttribute User user, BindingResult bindingResult){

//        입력된  값을 검증!!
        if(bindingResult.hasErrors()){
            return "user/user_join_form";
        }

//        회원가입로직 실행!!!
//        이름, 이메일, 패스워드 값을 얻어와서 log로 출력해보세요.

        log.info("name:{}",user.getName());
        log.info("password:{}",user.getPassword());
        log.info("email:{}",user.getEmail());
        return "redirect:/hi";
    }
        @GetMapping("/list")
        public String list (Model model) {
            List<User> users = Arrays.asList(
                    new User("김철수","1234","kim@exam.com"),
                    new User("안영미","123","an@exam.com"),
                    new User("홍길동","12345","hong@exam.com")
            );

            model.addAttribute("users",users);
            return "user/list";
        }

        @GetMapping("/update")
        public String update () {
            return null;
        }

        @GetMapping("/")
        public String index () {
            return null;
        }

}