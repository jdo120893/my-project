package org.example.securityexam.securityexam4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.securityexam.securityexam4.domain.UserRegisterDTO;
import org.example.securityexam.securityexam4.service.UserService;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "exam4/user/signup";
    }

    //    2. 회원가입해주세요.
    @PostMapping("/register")
    public String join(@ModelAttribute UserRegisterDTO user) {
        //이미 username 을 이용하는 사용자가 있는지 체크하고 간다면??  어떻게 구현하면 좋을지 고민해보기!!
        if (userService.existsUser(user.getUsername())) {
            log.info("이미 사용중인 아이디 :: " + user.getUsername());
            return "exam4/user/userreg-error";
        }

        userService.joinUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String lohinForm(){
        return "exam4/user/loginform";
    }

    @GetMapping("/myinfo")
    public String myinfo(){
        return "exam4/user/myinfo";
    }
}