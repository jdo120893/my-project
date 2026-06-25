package org.example.tododb_swagger_project.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtUtil {
    private static final String SECRET = "todo-secret-key-should-be-at-least-32-characters";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간
    private final ConcurrentHashMap<String, Boolean> invalidTokens = new ConcurrentHashMap<>();

    // 토큰 발급 (userId 저장)
    public String generateToken(Long userId) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
    }

    // 토큰 검증 + userId 추출
    public Long validateToken(String token) {
        try {
            if (invalidTokens.containsKey(token)) {
                return null;
            }
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
            return Long.parseLong(decodedJWT.getSubject());
        } catch (Exception e) {
            return null;
        }
    }

    // 로그아웃 - 블랙리스트 등록
    public void invalidateToken(String token) {
        invalidTokens.put(token, true);
    }
}