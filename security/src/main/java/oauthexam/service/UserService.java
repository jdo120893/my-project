package oauthexam.service;

import lombok.RequiredArgsConstructor;
import oauthexam.dto.SocialUserRequestDto;
import oauthexam.entity.Role;
import oauthexam.entity.User;
import oauthexam.repository.UserRepository;
import oauthexam.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Optional<User> findByProviderAndSocialId(String provider, String socialId) {
        return userRepository.findByProviderAndSocialId(provider, socialId);
    }

    @Transactional
    public User saveUser(SocialUserRequestDto requestDto){
        Role userRole = roleRepository.findByName("USER").orElseThrow(()-> new IllegalArgumentException("USER 권한이 없습니다. "));
        Set<Role> defaultRole = Set.of(userRole);
        User socialEntity = requestDto.toSocialEntity(passwordEncoder, defaultRole);
        return userRepository.save(socialEntity);
    }
}