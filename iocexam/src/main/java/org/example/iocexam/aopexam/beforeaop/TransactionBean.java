package org.example.iocexam.aopexam.beforeaop;

public class TransactionBean {
    public void startTransaction(){
        System.out.println("트랜잭션처리를 시작합니다.");
    }

    public void endTransaction() {
        System.out.println("트랜잭션처리를 마무리합니다.");
    }

}
