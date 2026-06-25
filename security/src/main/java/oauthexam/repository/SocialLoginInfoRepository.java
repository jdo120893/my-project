package oauthexam.repository;

import oauthexam.entity.SocialLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialLoginInfoRepository extends JpaRepository<SocialLoginInfo, Long> {
    Optional<SocialLoginInfo> findByProviderAndUuidAndSocialId(String provider, String uuid, String socialId);
}