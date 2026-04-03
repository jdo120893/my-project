package day03;

public class OperatorPractice2 {
    public static void main(String[] args) {
        int score = 80;
        System.out.println(++score);
        System.out.println(score += 9);

        byte value = 127;
        value += 5;
        System.out.println(value); // 오버플로우

    }
}
