package org.example.iocexam.aop.annotation;


import org.example.iocexam.aop.dormain.User2;
import org.example.iocexam.domain.User;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 서비스 클래스
@Service
public class UserService {

    @TrackTime
    public User2 findUserById(Long id) throws InterruptedException {
        // 시뮬레이션을 위한 지연
        Thread.sleep(1000);
        return new User2(id, "John Doe");
    }
}