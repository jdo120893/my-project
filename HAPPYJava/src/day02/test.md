calss - 틀, 설계도
매서드 명 main이란 매체를 시작하기위해 static 필요
매서드는 첫글자 소문자로쓰는게 관행

test.Car c2 = new test.Car();
c2.print();
Car 클래스실행을위해 new필요하고 c2 생성

String 문자열을 추상화 해놓은 클래스 [] < 배열

System 장치를 추상화 해놓은 클래스
표준입력 - 키보드 (System.in)
표준출력 - 콘솔 (System.out)

// 한줄 주석
/*../ 여러줄 주석
/**../ API 문서화용 JAVADOC

클래스 구성요소 - 필드(속성), 행위(매소드)

변수라는 매개에 값을 넣어서 사용

자바의 타입은 크게 2가지다
- 기본타임 (8개 존재 - 자바세상에서 유일하게 객체가 아닌것들)
 숫자 - 숫자 - 정수(크기에 따라서 byte, short, int, long)
            - 실수(float, double)
     - 문자 char(a, b, c)
 boolean - true, false
- 레퍼런스타입(객체) <- 데이터값이 들어가있음
