package test;

public class Practice {
    public static void main(String[] args) {




       String name = "정동욱";
       int age = 28;
       double height = 170;
       char grade = 'A';

       //printf  출력
        System.out.printf("이름: %s%n", name);
        System.out.printf("나이: %d세%n", age);
        System.out.printf("키: %.1fcm%n", height);
        System.out.printf("학점: %c%n", grade);


        System.out.printf("%s님은 %d세이고, 키는 %.1fcm입니다.%n", name,age
        , height);

        double pi = 3.141592653589793;
        System.out.printf("파이: %.2f%n", pi);
        System.out.printf("파이: %.4f%n", pi);


    }
}
