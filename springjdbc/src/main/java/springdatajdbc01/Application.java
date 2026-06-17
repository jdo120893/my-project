package springdatajdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, DeptRepository deptRepository, DataSourceTransactionManager dataSourceTransactionManager) {
        return args -> {
//            userRepository.save(new User("aaa","aaa@aaa.com"));

            userRepository.findAll().forEach(System.out::println);

//            userRepository.findById(1L).ifPresent(System.out::println);
            User user = userRepository.findById(1L).get();
            if(user != null) {
            System.out.println(user);
            }

            List<User> caramiUser = userRepository.findByName("carami");
            for(User u :caramiUser){
                System.out.println(u);
            }

            System.out.println("+".repeat(50));

            userRepository.findByName(("carami").forEach(System.out::println));

            deptRepository.save(new Dept("software Team","seoul"));

            deptRepository.findAll().forEach(System.out::println);
            deptRepository.findById(1).ifPresent(System.out::println);

            userRepository.addUser(user);
        };
    }

}
