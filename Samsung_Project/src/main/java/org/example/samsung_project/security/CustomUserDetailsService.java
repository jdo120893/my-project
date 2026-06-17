package org.example.samsung_project.security;

import lombok.RequiredArgsConstructor;
import org.example.samsung_project.Exception.UserNotFoundException;
import org.example.samsung_project.Repository.UserRepository;
import org.example.samsung_project.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLoginId(username)
                .orElseThrow(()->new UserNotFoundException("존재하지 않은 사용자입니다."+username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLoginId())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
