package org.example.mini_peoject_notice_board.repository;

import org.example.mini_peoject_notice_board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface BoardRepository extends CrudRepository<Board,Long>, PagingAndSortingRepository<Board,Long> {

    Page<Board> findByTitleContaining(String keyword, Pageable pageable);
    Page<Board> findByContentContaining(String keyword, Pageable pageable);
    Page<Board> findByNameContaining(String keyword, Pageable pageable);

}
