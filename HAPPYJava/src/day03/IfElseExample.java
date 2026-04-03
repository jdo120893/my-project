package day03;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 40;
//        if(score > 60) {
//            System.out.println("합격");
//        }else{
//            System.out.println("불합격");
//        }
//        System.out.println("수고하셨습니다.");
        if (score > 80) {
            System.out.println("완전합격");
        } else if (score > 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");

        }
    }
}
