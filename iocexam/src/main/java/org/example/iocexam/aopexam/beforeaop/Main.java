package org.example.iocexam.aopexam.beforeaop;

public class Main {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        dao.addUser();
    }
}
