package org.example.iocexam.aopexam.afteraop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserDao userDao, SimpleService simpleService){
        return args -> {
            System.out.println("======================");
            userDao.addUser();

            System.out.println("======================");

            simpleService.dosomething();

            System.out.println("======================");

            simpleService.hello();


            System.out.println("======================");
            String msg = simpleService.dosomething2();

            System.out.println(msg);

        };
    }
}