package org.example.mini_peoject_notice_board;

import org.example.mini_peoject_notice_board.domain.Board;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.mini_peoject_notice_board.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
public class MiniPeojectNoticeBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniPeojectNoticeBoardApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BoardRepository boardRepository) {
        return args -> {
            boardRepository.save(new Board("carami","제목","내용","비밀번호"));
    };
}
}
