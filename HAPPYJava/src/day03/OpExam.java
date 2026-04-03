package day03;

public class OpExam {
    public static  void main(String[] args) {
        int a = 10;
        int b = 3;
        int result = a+b;
        System.out.println(result);
        System.out.println(a/b); // 3 나눗셈 -정수
        System.out.println(a % b); // 1 나머지값만 구함

        //비교연산자
        boolean result2 = a == b;
        System.out.println(result2);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(b <= b);

        boolean x = true, y= false;
        System.out.println(x && y); // false (AND)
        System.out.println(x || y);
        System.out.println(!x);
        System.out.println(x ^ y);

        System.out.println("==========");
        System.out.println((a==b) && (a>b));
        System.out.println((a==b) || (a>b));
        System.out.println((a==b) ^ (a>b));
        System.out.println((a==b));

        int num = 10;
        num += 5; // num = num +5 (15)
        num -= 3; // num = num-3 (12)
        num *= 2; // num = num*2 (24)
        num /= 4; // num = num/4 (6)
        num %= 4; // num = num%4 (2) 눔을 4로나눈 나머지값

        int i = 10;

        System.out.println(i); //10
//        i++; 출력하고 더하기
        //// ++i; 더하고 출력하기
//        System.out.println(i);

        System.out.println(i++); // i=i+1 증감연산자
        System.out.println(i);
//        System.out.println(++i); // i=i+1

    }
}
