package day02;

import jdk.swing.interop.SwingInterOpUtils;

public class VariableTest {
    int i; //필드(속성)

    public static void main(String[] args) {
        //변수선언방법
        //접근제한자 타입 변수명;
        //접급제한자 타입 변수명 = 초기값;

        //지역변수
        //자바에서 변수의 범위는 괄호
        int i = 1;

        int ii;
        if (1 == 1) {
            ii = 10;
            System.out.println((ii));
        }

        System.out.println(ii);  //ii가 범위를 벗어남.
        System.out.println(i);

        //변수를 선언하는데 string 타입으로 name 이라는 변수를 선언해봅시다.
        String name; //선언
        name = "정동욱"; //초기화

        String name2 = "정동욱"; // 선언과 초기화 동시 할수도 있다.

        //변수
        Person jeong = new Person();
        System.out.println(jeong.age);

        int aaa=0;
        System.out.println(aaa);

        aaa=20;

        aaa=50;


        //final -- 상수는 단 한번만 초기화 가능
        final int MAX_SIZE;
        MAX_SIZE = 200;

//        MAX_SIZE = 300;

        int studentAge=20;




        System.out.println("\n");
        System.out.println("test");
        System.out.println("첫 번째 줄\n두 번째 줄");

        char c1 = 'A';
        char c2 = 65;
        char c3 = '\u0041';
        char c4 = '한';

        char c = 'a';
        int unicode = (int)c;        // 97
        System.out.println(unicode);

        char converted = (char)97;   // 'a'
        System.out.println(converted);


        //문자열은 너무 비번하게 사용되니까
        //자바에서 조금 특별하게 관리한다.
        String str = "abc";
        String str2 = new String("abc");

        System.out.println(10+20);

        int rusult = i+ii;

        //문자열은 + 결합가능
        System.out.println(str + 20);
        String sss = str + "abc" + true + 11.1;
        System.out.println(sss);
        System.out.println(str+(10+20));
        String s2 = ""+i;



    }
}
