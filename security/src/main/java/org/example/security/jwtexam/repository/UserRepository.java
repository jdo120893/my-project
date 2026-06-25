package org.example.security.jwtexam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.example.security.jwtexam.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}