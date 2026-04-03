package day03;

public class IFExam2 {
    public static void main(String [] args){
        int month=Integer.parseInt(args[0]);
        String season;
        if(month == 12 || month == 1 || month == 2){
            season = "겨울";
        } else if(month == 3 || month == 4 || month == 5){
            season = "봄";
        } else  if(month == 6 || month == 7 || month == 8){
            season = "여름";
        } else  if(month == 9 || month == 10 || month == 11){
            season = "가을";
        } else {
            season = "잘못된 월";
        }
    }
}
