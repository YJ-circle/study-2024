package time.test;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class TestCalendarPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년도를 입력하세요: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("월을 입력하세요: ");
        int month = sc.nextInt();
        sc.nextLine();

        LocalDate inputDate = LocalDate.of(year, month, 1);
        LocalDate lastDate = inputDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("inputDate.get(ChronoField.DAY_OF_WEEK) = " + inputDate.get(ChronoField.DAY_OF_WEEK));

        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
        System.out.print(" ".repeat(4*inputDate.get(ChronoField.DAY_OF_WEEK)));
        int i = 1;
        while (i <= lastDate.getDayOfMonth()) {
            System.out.print(i + "  ");
            if (inputDate.get(ChronoField.DAY_OF_WEEK) == 6) {
                System.out.println();
            }
            inputDate = inputDate.plusDays(1);
            i++;
        }
        //////////////////////////////////////////////
        System.out.println();
        System.out.println();
        System.out.println("YH");

        printCalendar(year, month);

    }

    private static void printCalendar(int year, int month) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate firstDayOfNextMonth = firstDayOfMonth.plusMonths(1);


        System.out.println("Su Mo Tu We Th Fr Sa ");
        //몇칸 띄울지를 알려면.. 첫번째가 어떤 요일인지 알아야한다.

        //얼마나 띄울지 계산
        //월요일 1%7 = 1 .. 일요일 7%7 = 0
        int offsetWeekDays = firstDayOfMonth.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < offsetWeekDays; i++) {
            System.out.print("   ");
        }
        LocalDate dayIterator = firstDayOfMonth;
        while (dayIterator.isBefore(firstDayOfNextMonth)) {
//            System.out.print(dayIterator.getDayOfMonth() + " ");
//            항상 2칸을 차지하게 수정
            System.out.printf("%2d ", dayIterator.getDayOfMonth());
            if (dayIterator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            dayIterator = dayIterator.plusDays(1);
        }
    }
}
