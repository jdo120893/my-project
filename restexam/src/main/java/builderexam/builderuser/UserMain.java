package builderexam.builderuser;

public class UserMain {
    public static void main(String[] args) {
        User kang = new User.Builder().name("강경미")
                .age(20)
                .email("carami@gmail.com")
                .address("경기도 고양시")
                .build();

        System.out.println(kang);

        User kim = new User.Builder()
                .name("kim")
                .build();

        System.out.println(kim);

        User hong = new User.Builder()
                .address("서울시 양천구")
                .age(10)
                .build();

        System.out.println(hong);

        User lee = User.builder()
                .name("lee")
                .build();

        System.out.println(lee);
    }
}
