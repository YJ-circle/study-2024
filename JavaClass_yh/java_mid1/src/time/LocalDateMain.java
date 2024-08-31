package time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2024, 8, 31);

        System.out.println("오늘 날짜 = "  +  nowDate);
        System.out.println("지정 날짜 = " + ofDate);

        //계산

        //불변 객체로 설계되서 변하지 않음.
        ofDate.plusDays(10);
        System.out.println("지정 날짜 + 10d = " + ofDate);


        // 반환 값을 받아서 처리해야함.
        // 변경이 발생하는 경우 새로운 객체를 생성해서 반환한다. 그러므로 꼭 반환 값을 받아야한다.

        ofDate = ofDate.plusDays(10);
        System.out.println("지정 날짜 + 10d = " + ofDate);

    }
}
