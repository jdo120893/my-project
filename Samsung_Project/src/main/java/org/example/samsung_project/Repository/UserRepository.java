package org.example.samsung_project.Repository;


import org.example.samsung_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);
    Optional<User> findByLoginId(String loginId);
//    boolean existsByUsername(String username);
    boolean existsByLoginId(String LoginId);
}
