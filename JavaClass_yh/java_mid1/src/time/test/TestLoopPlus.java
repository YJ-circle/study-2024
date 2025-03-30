package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestLoopPlus {
    public static void main(String[] args) {
        LocalDate dt1 = LocalDate.of(2024, 1, 1);
        for (int i = 0; i < 5; i++) {
            System.out.println(dt1);
            dt1 = dt1.plusDays(14);
        }

        //YH
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        for (int i = 0; i < 5; i++) {
            LocalDate nextDate = startDate.plus(2 * i, ChronoUnit.WEEKS);
            System.out.println("날짜 " + (i+1) + ": " + nextDate);
        }
    }
}
