package sample.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Dice {
//    Logger logger2 = LoggerFactory.getLogger(Dice.class);
    private int face=6;
    public Dice(){
        System.out.println("Dice() 생성");
//        logger2.info("Dice() 생성자 호출!!");
    }

    public Dice(int face){
        this.face = face;
        System.out.println("Dice(int) 실행!!");
//        logger2.info("Dice() 생성자 호출!!");
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getNumber(){
        return (int)(Math.random()*face)+1;
    }

    @PostConstruct
    public void init(){
        System.out.println("Dice 가 생성된 직 후에 호출됨!!!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("객체가 소멸되기 전에 호출됨!!!");
    }
}