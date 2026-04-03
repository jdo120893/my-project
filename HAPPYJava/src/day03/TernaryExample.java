package day03;

public class TernaryExample {
    public static void main(String[] args){
        int number = Integer.parseInt(args[0]);

        String result = (number % 2 == 0) ? "짝수":"홀수";

        System.out.println(result);
    }
}
