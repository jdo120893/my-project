package org.example.swaggerexam.service;

import lombok.RequiredArgsConstructor;
import org.example.swaggerexam.entity.User;
import org.example.swaggerexam.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String register(String email, String password){

        if (userRepository.findByEmail(email).isPresent()){

            return "존재하는 아이디 입니다.";
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        return "회원가입성공!";
    }
}
