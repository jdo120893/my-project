package org.example.security.jwtexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.security.jwtexam.domain.RefreshToken;
import org.example.security.jwtexam.repository.RefreshTokenRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    //저장
    @Transactional
    public RefreshToken addRefreshToken(RefreshToken refreshToken){
        return refreshTokenRepository.save(refreshToken);
    }

    //조회
    @Transactional(readOnly = true)
    public Optional<RefreshToken> findRefreshToken(String refreshToken){
        return refreshTokenRepository.findByToken(refreshToken);
    }


    //삭제
    @Transactional
    public void deleteRefreshToken(String refreshToken){
        refreshTokenRepository.findByToken(refreshToken)
                .ifPresent(refreshTokenRepository::delete);
    }

    public Optional<RefreshToken> findByUserId(Long userId) {
        return refreshTokenRepository.findById(userId);
        // 또는 RefreshTokenRepository에 findByUserId가 따로 있다면 그걸 사용
    }


}