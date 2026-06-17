package org.example.mini_peoject_notice_board.exception;

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException() {
        super("암호가 일치하지 않습니다.");
    }
}