package time.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class TestZone {
    public static void main(String[] args) {
//        ZonedDateTime dt = ZonedDateTime.of(2024, 1, 1, 9, 0, 0, 0, ZoneId.of("Asia/Seoul"));

        //YH
        ZonedDateTime dt = ZonedDateTime.of(LocalDate.of(2024, 1, 1),
                                            LocalTime.of(9, 0),
                                            ZoneId.of("Asia/Seoul"));

        ZonedDateTime london = dt.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newyork = dt.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("서울의 회의 시간: " + dt);
        System.out.println("런던의 회의 시간: " + london);
        System.out.println("뉴욕의 회의 시간: " + newyork);
    }
}
