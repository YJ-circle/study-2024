package time.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TestLoopPlues2 {
    public static void main(String[] args) {
        LocalDate dt = LocalDate.of(2024, 1, 1);
        for (int i = 0; i < 5; i++) {
            LocalDate addDt = dt.plusWeeks(2*i);
            System.out.println(addDt);
        }

    }
}
