package org.example.samsung_project.Service;

import lombok.RequiredArgsConstructor;
import org.example.samsung_project.Exception.DuplicateUserException;
import org.example.samsung_project.Exception.UserNotFoundException;
import org.example.samsung_project.Repository.UserRepository;
import org.example.samsung_project.domain.User;
import org.example.samsung_project.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public User createUser(UserDto userDto) {
        if (userRepository.existsByLoginId(userDto.getLoginId())) {
            throw new DuplicateUserException("이미 존재하는 로그인 ID입니다.");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setLoginId(userDto.getLoginId());
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // BCrypt 암호화
        user.setEmail(userDto.getEmail());
        user.setRole("USER"); // 기본 역할 부여

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다."));
        userRepository.delete(user);
    }

    public boolean isLoginIdTaken(String loginId){
        return userRepository.existsByLoginId(loginId);
    }
}