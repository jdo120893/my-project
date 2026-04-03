package day03;

public class SwiitchExample {
    public static void main(String[]args){
        int month = 1;
        String season;

        switch (month){
        case 1:
        case 2:
        case 3:
            season ="봄";
            break;
        case 4:
        case 5:
        case 6:
            season ="여름";
            break;
        case 7:
        case 8:
        case 9:
             season ="가을";
              break;
        case 10:
        case 11:
        case 12:
            season ="겨울";
            break;
        default:
            season= "기타";
            break;

        }
        System.out.println(month+"월은"+season+"입니다.");
    }
}
