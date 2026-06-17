package org.example.securityexam.securityexam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//        기본설정
        http
                .authorizeHttpRequests(auth -> auth
                    .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
        .rememberMe(rememberMe->rememberMe
                .tokenValiditySeconds(60))
                .httpBasic(Customizer.withDefaults())
                .csrf(Customizer.withDefaults());



//        http.authorizeHttpRequests(auth->auth
//                        .requestMatchers("/","/loginForm","/test/*","/fail").permitAll()
//                        .anyRequest().authenticated()
//        )
//                .formLogin(formLogin->formLogin
//                        .loginProcessingUrl("/login_proc")
//                        .loginPage("/loginForm")
////                        .defaultSuccessUrl("/info",true)
//                        .failureUrl("/fail")
//                        .usernameParameter("email")
//                        .passwordParameter("passwd")
//                        .successHandler((request, response, authentication)->{
//                    log.info("로그인 성공!!" + authentication.getName());
//                    response.sendRedirect("/info");
//        })
//                                .failureHandler((request, response, exception) -> {
//                                    log.info("로그인 실패!!" + exception.getMessage());
//                                    response.sendRedirect("/loginForm");
//                                })
//        )
//                .logout(logout->logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .addLogoutHandler((request, response, authentication)->{
//                            log.info("로그아웃 세션,쿠키삭제");
//                            HttpSession session = request.getSession();
//                            if (session != null)
//                                session.invalidate();
//                        })
//                        .deleteCookies("JSESSIONID")
//                );


        http.csrf(csrf->csrf.disable());


        return http.build();
    }

}
