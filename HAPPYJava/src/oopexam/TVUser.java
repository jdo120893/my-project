package oopexam;

public class TVUser {
    public static void main(String[] args) {
        CaramiTv tv = new CaramiTv();

        tv.turnOn();
        tv.volumeDOWN();
        tv.volumeUP();
        tv.volumeDOWN();
        tv.turnOff();
        System.out.println("\n====================");

        STV tv2 = new STV();

        tv2.turnOn();
        tv2.volumeDOWN();
        tv2.volumeUP();
        tv2.volumeDOWN();
        tv2.turnOff();
    }
}
