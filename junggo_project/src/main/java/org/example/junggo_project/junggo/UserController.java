package org.example.junggo_project.junggo;

import org.example.junggo_project.junggo.user.dto.UserDTO;
import org.example.junggo_project.junggo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }


    @GetMapping("/user/join")
    public String joinForm(){
        return "user/user";
    }

    @PostMapping("/user/join")
    public String signup(@ModelAttribute UserDTO dto){

        boolean isSuccess = userService.insertUser(dto);

        if(isSuccess) {
            System.out.println(dto.getName() + "님 가입 완료 폰번호: " + dto.getPhone_number());

            return "redirect:/";
        }else {
            System.out.println("DB 저장 실패");
            return "redirect:/user/join";
        }
    }
}
