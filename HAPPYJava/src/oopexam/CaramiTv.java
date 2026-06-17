package oopexam;

import day07.Vehicle;

public class CaramiTv implements TV{

    public void turnOn(){
        System.out.println("사용자가 turnOn 한다.");
    }

    public void turnOff(){
        System.out.println("사용자가 turnOff 한다.");
    }

    public void volumeDOWN(){
        System.out.println("사용자가 볼륨을 낮춘다");
    }

    public void volumeUP(){
        System.out.println("사용자가 볼륨을 높인다.");
    }
}
