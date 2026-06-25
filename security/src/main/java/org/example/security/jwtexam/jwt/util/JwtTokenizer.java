package org.example.security.jwtexam.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenizer{

    private final byte[] accessSecret;
    private final byte[] refreshSecret;

    private final long accessExpirationMs;
    private final long refreshExpirationMs;

    public JwtTokenizer(@Value("${jwt.secretKey}") String accessSecret,
                        @Value("${jwt.refreshKey}") String refreshSecret,
                        @Value("${jwt.refresh-expiration-ms}") long accessExpirationMs,
                        @Value("${jwt.access-expiration-ms}") long refreshExpirationMs){

        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);

        this.accessExpirationMs = accessExpirationMs;
        this.refreshExpirationMs = refreshExpirationMs;
    }

    public String createAccessToken(Long id, String name,
                                    String email, String username, List<String> roles){

        return createToken(id, name, email, username, roles, accessExpirationMs, accessSecret);
    }

    public String createRefreshToken(Long id, String name,
                                     String email, String username, List<String> roles){

        return createToken(id, name, email, username, roles, refreshExpirationMs, refreshSecret);
    }

    public String createToken(Long id, String name, String username, String email, List<String> roles, Long expire, byte[] secretKey){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expire);

        return Jwts.builder()
                .subject(username)
                .claim("email",email)
                .claim("name", name)
                .claim("loginId", id)
                .claim("roles", roles)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getSigningKey(secretKey))
                .compact();
    }

    public SecretKey getSigningKey(byte[] secretKey){

        return Keys.hmacShaKeyFor(secretKey);
    }

    private Claims parseToken(String token, byte[] secret) {
        token = removeBearerPrefix(token);

        return Jwts.parser()
                .verifyWith(getSigningKey(secret))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Claims parseAccessToken(String accessToken) {
        return parseToken(accessToken, accessSecret);
    }

    public Claims parseRefreshToken(String refreshToken) {
        return parseToken(refreshToken, refreshSecret);
    }



        //    토큰에서 id만 꺼내고 싶다.
//    Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJhbWlAZ21haWwuY29tIiwidXNlcm5hbWUiOiJjYXJhbWkiLCJuYW1lIjoi6rCV6rK966-4IiwidXNlcklkIjoxLCJyb2xlcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImlhdCI6MTc4MTc1MDM4NiwiZXhwIjoxNzgxNzUyMTg2fQ.KHE2ij1_cA5Y276TNd96zN1fvYPTKtp5Z3t_f9YPtVg
        public Long getUserIdFromToken(String token){

//        if(token.startsWith("Bearer ")){
//            token = token.substring(7);
//        }
            token = removeBearerPrefix(token);

            Claims claims = parseToken(token, accessSecret);
            return  claims.get("userId",Long.class);
        }


        private String removeBearerPrefix(String token) {

            if(token == null) {
                return null;
            }

            if(token.startsWith("Bearer ")) {
                return token.substring(7);
            }

            return token;
        }

        public Long getAccessTokenExpireCount(){
            return accessExpirationMs;
        }

        public Long getRefreshTokenExpireCount(){
            return refreshExpirationMs;
        }

    }
