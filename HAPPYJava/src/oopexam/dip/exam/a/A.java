//package oopexam.dip.exam.a;
//// 수정 후(의존관계: B → A, 인터페이스 활용)
//
//// 새로 추가하는 인터페이스: A는 이 인터페이스만 알고 있음
//public interface BInterface {
//    void b();
//}
//
//// A는 이제 BInterface에만 의존
//public class A {
//    public void a(BInterface bInterface) {
//        bInterface.b();
//    }
//}