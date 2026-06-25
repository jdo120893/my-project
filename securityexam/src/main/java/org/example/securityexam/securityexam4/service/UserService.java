package org.example.securityexam.securityexam4.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.securityexam.securityexam4.domain.Role;
import org.example.securityexam.securityexam4.domain.User;
import org.example.securityexam.securityexam4.domain.UserRegisterDTO;
import org.example.securityexam.securityexam4.repository.RoleRepository;
import org.example.securityexam.securityexam4.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public User joinUser(UserRegisterDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        Role userRole = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);

    }

    //    username에 해당하는 user가 있는지 체크하는 기능
    public boolean existsUser(String username){
        return userRepository.existsByUsername(username);
    }
}