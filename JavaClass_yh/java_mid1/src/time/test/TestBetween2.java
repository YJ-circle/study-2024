package time.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TestBetween2 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);
        //Period, Duration
        System.out.println("Period.between(startDate, endDate) = " + Period.between(startDate, endDate));
        System.out.println("days = " + ChronoUnit.DAYS.between(startDate, endDate));
    }
}
