package day03;

public class PrimitiveCastExam {
    public static void main(String[] args) {
        //형변환(타입이 바뀌는것!!)
        byte b = 10;
        int i = b;  // byte -> int형 변환이 일어남
        // 숫자라는 공통점 형변환이 가능하다
        // 작은그릇에 담김값을 큰그릇에 옮기는 것은 가능하다

        boolean flag = true;
//        b = flag; 완전히 관련이 없는 것들은 형변환 불가
        //그릇안에 들어있는 값까지는 신경안쓴다 컴파일러는
        //그릇의 크기만 봐요
        b = (byte)i; // 반대일경우 프로그래머가 반드시 형변환시켜주기 -> 명시적 형변환

        //그릇의 크기 정수는 소수점이하는 받을 수 없어서 그릇의 크기와 상관없이 받을 수 없다
        float f = 10.6f;
        long l = (long)f; // 명시적으로 형변환을 시켜줘야 받을 수 있음
        System.out.println(l);

        char a ='a';
        System.out.println(a);
        System.out.println((int)a);
        System.out.println((char)98);

        int xx = 10;
        int yy = 3;

        double d = xx/(double)yy; // 실수 변환 3.333333333335
        System.out.println(d);


    }
}
