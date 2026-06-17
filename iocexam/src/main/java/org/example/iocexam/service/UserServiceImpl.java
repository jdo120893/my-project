package org.example.iocexam.service;

import jakarta.annotation.Resource;
import org.example.iocexam.dao.UserDao;
import org.example.iocexam.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Component
@Service
public class UserServiceImpl implements UserService{
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

//    @Autowired
//    @Qualifier("caramiDao")
    private UserDao userDao;

//    public UserServiceImpl(UserDao userDao){
//        this.userDao = userDao;
//    }

    public UserServiceImpl(){
        System.out.println("UserServiceImpl() 생성자 호출!!");
        logger.debug("UserServiceImpl debug level");
        logger.info("UserServiceImpl() 생성자 호출!!");
        logger.warn("UserServiceImpl() warn logger!!");
        logger.error("UserServiceImpl() error logger!!");
    }

//    public UserServiceImpl(@Qualifier("caramiDao") UserDao userDao){
//        this.userDao = userDao;
//    }

    @Resource
    public void setUserDao(@Qualifier("caramiDao") UserDao userDao) {
        System.out.println("setUserDao() 실행");
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {

        userDao.addUser(user);
    }
}

