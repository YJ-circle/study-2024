package time.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

public class TestBetween {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);
        ChronoPeriod between = ChronoPeriod.between(startDate, endDate);
        System.out.println("시작 날짜: " + startDate);
        System.out.println("목표 날짜: " + endDate);

        System.out.println("남은 기간: " + between.get(ChronoUnit.YEARS) + "년 " + between.get(ChronoUnit.MONTHS) + "개월 " + between.get(ChronoUnit.DAYS) + "일");
//        System.out.println(between.getUnits(ChronoUnit.DAYS));

        //YH

        Period period = Period.between(startDate, endDate);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("시작 날짜: " + startDate);
        System.out.println("목표 날짜: " + endDate);
        System.out.println("남은 기간: " + period.getYears() + "년 "
                          + period.getMonths() + "월 " + period.getDays() + "일 남음");
        System.out.println("디데이: " + daysBetween);

    }
}
