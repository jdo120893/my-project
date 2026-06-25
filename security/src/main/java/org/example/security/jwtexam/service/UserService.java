package org.example.security.jwtexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.security.jwtexam.domain.User;
import org.example.security.jwtexam.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}