package org.example.mini_peoject_notice_board.repository;

import org.example.mini_peoject_notice_board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void save(){
        Board board = new Board("name","title","content","password");
        Board savedBoard = boardRepository.save(board);

        assertThat(savedBoard.getId()).isNotNull();
    }

    @Test
    void paging() {
        boardRepository.findAll(PageRequest.of(0,3)).forEach(System.out::println);
    }

}