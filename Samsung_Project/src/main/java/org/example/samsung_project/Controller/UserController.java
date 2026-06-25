package org.example.samsung_project.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.samsung_project.domain.User;
import org.example.samsung_project.dto.UserDto;
import org.example.samsung_project.Service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController { // 클래스 이름은 깔끔하게 UserController로 통일하는 것을 추천합니다!
    private final UserService userService;

    // 1. 회원가입 화면 보여주기
    @GetMapping("/user/register")
    public String register() {
        return "/user/signup"; // src/main/resources/templates/user/signup.html
    }

    // 2. 회원가입 처리 (아이디 중복 체크 포함)
    @PostMapping("/user/register")
    public String join(@ModelAttribute UserDto userDto) {
        // 이미 사용 중인 아이디인지 체크
        if (userService.isLoginIdTaken(userDto.getLoginId())) {
            log.info("이미 사용중인 아이디 :: " + userDto.getLoginId());
            return "/user/userreg-error"; // 에러 페이지로 이동
        }

        userService.createUser(userDto);
        return "redirect:/"; // 가입 성공 시 메인 화면으로 이동
    }

    // 3. 로그인 화면 보여주기
    @GetMapping("/user/loginform")
    public String loginForm() {
        return "/user/loginform"; // src/main/resources/templates/user/loginform.html
    }

    // 마이페이지 화면 보여주기
    @GetMapping("/myinfo")
    public String myinfo(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/user/loginform";
        }

        // loginId(username)로 DB에서 유저 조회
        User loginUser = userService.findByLoginId(userDetails.getUsername());
        model.addAttribute("user", loginUser);

        return "/user/myinfo";
    }

    // 5. [합쳐진 기능] 회원 탈퇴 처리
    // HTML 폼 전송을 위해 POST 방식으로 매핑하고, URL도 기존 컨벤션에 맞췄습니다.
    @PostMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        log.info("회원 탈퇴 완료 :: 회원 번호 " + id);

        // 탈퇴 후에는 세션이 끊기므로 로그인 폼으로 보냅니다.
        return "redirect:/user/loginform";
    }
}