package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// <참고> 실무에서는 Logger라는 라이브러리를 따로 사용한다.
public abstract class MyLogger {
    // 추상 메소드로 선언해서 직접 객체를 생성할 수 없도록 한다.

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    //시 분 초. 미리초
    
    public static void log(Object obj){
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
}
