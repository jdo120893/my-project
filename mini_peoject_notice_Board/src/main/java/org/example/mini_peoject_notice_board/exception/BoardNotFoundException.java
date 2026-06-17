package org.example.mini_peoject_notice_board.exception;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException(Long id) {
        super("id=" + id + " 게시글을 찾을 수 없습니다.");
    }
}