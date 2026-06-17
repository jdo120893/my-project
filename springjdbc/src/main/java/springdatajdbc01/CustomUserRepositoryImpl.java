package springdatajdbc01;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        String sql = "insert into users(name, email) value(?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getEmail());
    }
}
