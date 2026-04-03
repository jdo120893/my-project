package day03;

public class IfElseIfPractice1 {
    public static void main(String[] args) {
        // 프로그램 박에서 받아오는 값은 모두 문자다
        //ex) java Hello 20 -- 이 때 20은 문자열이다
        // 문자열로 받은 값을 정수로 바꿔주어야 한다
        // 리턴이 없는 매서드 void
        //String 으로 받은 값을 int 로 변환해야함


        //명령형 매개변수
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(args[3]);
        System.out.println("============");
        int dust = Integer.parseInt(args[0]);

//        int dust = 75; //미세먼지 수치

        if(dust <= 30) {
        System.out.println("좋음");
        } else if(dust <= 80) {
            System.out.println("보통");
        } else if(dust <= 150) {
            System.out.println("나쁨");
        } else {
            System.out.println("매우나쁨");
        }
    }
}
