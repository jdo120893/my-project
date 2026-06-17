package org.example.securityexam.securityexam4;

import lombok.extern.slf4j.Slf4j;
import org.example.securityexam.securityexam4.domain.Role;
import org.example.securityexam.securityexam4.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Exam4Application {
    public static void main(String[] args) {
        SpringApplication.run(Exam4Application.class);
    }

    @Bean
    public CommandLineRunner run(RoleRepository roleRepository){
        return args -> {
            if(roleRepository.count() == 0){
                Role userRole = new Role();
                userRole.setName("USER");
                Role adminRole = new Role();
                adminRole.setName("ADMIN");

                roleRepository.saveAll(List.of(userRole,adminRole));
                log.info("USER,ADMIN 권한이 추가되었습니다.");
            }else {
                log.info("권한 정보가 이미 존재합니다.");
            }
        };
    }
}
