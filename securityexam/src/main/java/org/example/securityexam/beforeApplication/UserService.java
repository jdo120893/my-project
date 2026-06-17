package org.example.securityexam.beforeApplication;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void threadLocalTest(){
        System.out.println("User::"+UserContext.getUser().getName());
    }
}
