package day03;

public class IfElseIFPractice2 {
    public static void main(String[]args){
        int price = 120000;
        int finalPrice = 0;

        if(price >= 100000) {
            finalPrice = (int)(price * 0.8);
        } else if(price >= 50000) {
            finalPrice = (int)(price * 0.9);
        } else {finalPrice = price;}

        System.out.println("원래가격:"+price+"원");
        System.out.println("최종할인가격:"+finalPrice+"원");

        }
    }

