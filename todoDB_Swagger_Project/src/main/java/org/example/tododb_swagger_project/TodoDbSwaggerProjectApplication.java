package org.example.tododb_swagger_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoDbSwaggerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoDbSwaggerProjectApplication.class, args);
    }

}
