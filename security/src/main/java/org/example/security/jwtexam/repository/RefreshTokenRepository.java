package org.example.security.jwtexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.security.jwtexam.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}