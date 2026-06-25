package oauthexam.dto;

import lombok.Getter;
import lombok.Setter;
import oauthexam.entity.Role;
import oauthexam.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class SocialUserRequestDto {
    private String provider;
    private String socialId;
    private String name;
    private String email;
    private String username;
    private String uuid;


    public User toSocialEntity(PasswordEncoder passwordEncoder, Set<Role> defaultRoles){
        //소셜사용자는 비밀번호가 없고,  우리 User entity는 password가 notnull 제약조건을 가지고 있기때문에...  임의의 문자열을 저장해줄꺼예요.
        String encodedPassword = passwordEncoder.encode(UUID.randomUUID().toString());

        return User.builder()
                .username(this.username)
                .name(this.name)
                .email(this.email)
                .socialId(this.socialId)
                .provider(this.provider)
                .password(encodedPassword)
                .roles(defaultRoles)
                .build();
    }

}