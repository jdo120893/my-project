package jdbc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcExam03 implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(JdbcExam03.class, args);
    }

    @Autowired
    DeptDao deptDao;

    @Override
    public void run(String... args) throws Exception {
        deptDao.insertDept(new Dept("Programming Team","soeul"));

    }
}
