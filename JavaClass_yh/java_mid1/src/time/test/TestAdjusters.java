package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestAdjusters {
    public static void main(String[] args) {
        int year = 2024;
        int month = 1;
        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek firstDayofWeek = date.getDayOfWeek();
        DayOfWeek lastDayofWeek = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
        System.out.println("firstDayofWeek = " + firstDayofWeek);
        System.out.println("lastDayofWeek = " + lastDayofWeek);
    }
}
