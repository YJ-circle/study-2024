package time;

import java.time.ZoneId;

public class ZoneIdMain {
    public static void main(String[] args) {

        //이용가능한 zone 아이디를 가져올 수 있다.

        //방법1. 다 가져오기
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + " | " + zoneId.getRules());

        }

        //방법2. 운영체제 설정 가져오기
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("ZoneId.systemDefault = " + zoneId);

        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        System.out.println("seoulZoneId = " + seoulZoneId);
    }
}
