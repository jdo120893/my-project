package org.example.springdatajpa;

import jakarta.transaction.Transactional;
import org.example.springdatajpa2.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
//@SpringBootTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() throws Exception {
        userRepository.deleteAll();

        userRepository.save(new User("carami","carami@gmail.com"));
        userRepository.save(new User("carami","carami2@gmail.com"));
        userRepository.save(new User("kang","kang@gmail.com"));
        userRepository.save(new User("kim","kim@gmail.com"));
        userRepository.save(new User("hong","hong@gmail.com"));
        userRepository.save(new User("lee","lee@gmail.com"));
    }

    @org.example.springdatajpa2.Order(3)
    @Test
    void findByName(){
        List<User> users = userRepository.findByName("carami");

        assertThat(users).hasSize(2);

    }

    @Test
    @org.example.springdatajpa2.Order(1)
    @DisplayName("기본 CRUD: save & findById")
    void save_and_findById() {
        User saved = userRepository.save(new User("Hong", "hong@example.com"));
        Optional<User> found = userRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Hong");
        assertThat(found.get().getEmail()).isEqualTo("hong@example.com");
    }

    @Test
    @org.example.springdatajpa2.Order(2)
    @DisplayName("파생 쿼리: findByName / findByEmail")
    void derived_queries_findByName_and_findByEmail() {
        List<User> kangs = userRepository.findByName("kang");
        List<User> emailHit = userRepository.findByEmail("lee@gmail.com");

        assertThat(kangs).hasSize(1);
        assertThat(emailHit).hasSize(1);
        assertThat(emailHit.get(0).getName()).isEqualTo("lee");
    }

    @Test
    @org.example.springdatajpa2.Order(5)
    @DisplayName("@Modifying JPQL: deleteByEmail")
    void modifying_deleteByEmail() {
        int deleted = userRepository.deleteByEmail("kang@gmail.com");
        assertThat(deleted).isEqualTo(1);

        List<User> remains = userRepository.findByEmail("kang@gmail.com");
        assertThat(remains).isEmpty();
    }

    @Test
    @Order(6)
    @DisplayName("@Modifying JPQL: updateByEmail")
    void modifying_updateByEmail() {
        User target = userRepository.findByEmail("kang@gmail.com").get(0);
        int updated = userRepository.updateByEmail(target.getId(), "kang@newgmail.com");
        assertThat(updated).isEqualTo(1);

        List<User> oldEmail = userRepository.findByEmail("kang@gmail.com");
        List<User> newEmail = userRepository.findByEmail("kang@newgmail.com");

        assertThat(oldEmail).isEmpty();
        assertThat(newEmail).hasSize(1);
        assertThat(newEmail.get(0).getName()).isEqualTo("kang");
    }


}