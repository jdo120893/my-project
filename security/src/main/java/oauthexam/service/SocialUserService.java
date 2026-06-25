package oauthexam.service;


import lombok.RequiredArgsConstructor;
import oauthexam.entity.SocialUser;
import oauthexam.repository.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialUserService {

    private final SocialUserRepository socialUserRepository;

    //소셜에서 보내준 정보를 저장하기 위한 메서드
    public SocialUser saveOrUpdateUser(String socialId, String provider,
                                       String username, String email, String avatarUrl) {
        Optional<SocialUser> existingUser =
                socialUserRepository.findBySocialIdAndProvider(socialId, provider);

        SocialUser socialUser;
        if (existingUser.isPresent()) {
            socialUser = existingUser.get();
            socialUser.setUsername(username);
            socialUser.setEmail(email);
            socialUser.setAvatarUrl(avatarUrl);
        } else {
            socialUser = new SocialUser();
            socialUser.setSocialId(socialId);
            socialUser.setProvider(provider);
            socialUser.setUsername(username);
            socialUser.setEmail(email);
            socialUser.setAvatarUrl(avatarUrl);
        }

        return socialUserRepository.save(socialUser);
    }
}