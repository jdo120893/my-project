package day02;

import test.Car;

public class HelloWorld {

    public int name;
    int test; //패키지
    protected int a;
    private int b;


    public static void main(String[] args) {
        System.out.println("Hello");

        Car.add();

        System.out.println(("Hello"));

        test.Car c2 = new test.Car();
        c2.print();

        System.out.println(10);
    }
}
