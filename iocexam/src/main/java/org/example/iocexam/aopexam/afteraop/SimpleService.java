package org.example.iocexam.aopexam.afteraop;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public void dosomething(){
        System.out.println("simpleService의 dosomething run!!");
    }

    public String dosomething2(){
        System.out.println("simpleService2의 dosomething run!!");

//        try {
//            if (1 == 1)
//                throw new RuntimeException();
//        }catch (Exception e){}
        return "carami";
    }

    public void hello(){
        System.out.println("hello 실행!!");
    }
}
