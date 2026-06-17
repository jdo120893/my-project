package org.example.securityexam.securityexam4.repository;

import org.example.securityexam.securityexam4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
    boolean existsByUsername(String username);
    }

