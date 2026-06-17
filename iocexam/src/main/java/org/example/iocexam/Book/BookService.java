package org.example.iocexam.Book;

import org.example.iocexam.domain.User;
import org.example.iocexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookDao bookDao;

    public BookService(BookDao bookDao){
        this.bookDao = bookDao;
    }

    public void test(){
        bookDao.test();
    }
}