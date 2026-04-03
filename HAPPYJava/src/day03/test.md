- byte, short, char 연산 시 → int로 승격 
  피연산자 중 더 큰 타입으로 승격하여 연산 
  이유: JVM은 int를 기본 연산 단위로 사용하여 성능을 최적화합니다.
  32비트(int) 단위로 처리하는 것이 현대 CPU에서 가장 효율적입니다.

- 크기순서
  byte → short → int → long → float → double
        ↘ char

- 증감연산자
i++; 출력하고 더하기
//// ++i; 더하고 출력하기
- 핵심
  기본 타입: byte, short, int, long, float, double, boolean, char
  타입 변환: 자동(작은→큰), 강제(큰→작은)
  연산자: 산술, 비교, 논리, 대입, 증감
  주의사항: 산술 승격, 오버플로우, 소수부 버림
- 삼합연산자
  if문: 조건에 따른 분기 처리
  switch문: 값에 따른 다중 분기 (break 필수)
  삼항 연산자: 간단한 조건 처리의 축약

  public static void main(String[] args){
  int number = Integer.parseInt(args[0]);

        String result = (number % 2 == 0) ? "짝수":"홀수";
                     number를 2로나눤값이 0이란 같니?

        System.out.println(result);