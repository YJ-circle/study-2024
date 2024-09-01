package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {
    public static void main(String[] args) {
        //포맷팅: 날짜를 문자로
        LocalDate date = LocalDate.of(2024, 12, 31);
        System.out.println("date = " + date); // ISO표준 입출력으로 출력된다.

        //막하는 법
        System.out.println(date.getYear() + "년 "+ date.getMonthValue() + "월 " + date.getDayOfMonth() + "일");

        //포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy년 MM월 dd일"));
        String formattedDate = date.format(formatter);
        System.out.println("날짜와 시간 포맷팅 = " + formattedDate);

        //파싱: 문자를 날짜로
        String input = "2030년 01월 02일";
        LocalDate parsed = LocalDate.parse(input, formatter);
        System.out.println("문자열 파싱 날짜와 시간 " + parsed);


    }
}
