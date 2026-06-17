package org.example.springdatajpa;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    //    CRUD 에 해당하는 메서드들을 구현해보세요.
    public User addUser(User user){
        return userRepository.save(user);
    }

    //수정
    @Transactional
    public User updateUser(User user){
        User updateUser = userRepository.findById(user.getId()).
                orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. ::" + user.getId()));

        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());

        return updateUser;
    }
    //삭제

    //조회 (여러건)

    //id 에 해당하는 한건 조회


}