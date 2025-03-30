package thread.start;
import static util.MyLogger.log;

public class InnerRunnableMainV3 {
    public static void main(String[] args) {

        log("main() start");
        log("main() end");

        //익명 클래스 사용하기 + 변수 선언안하고 바로 사용
        // Inline Variable
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();
    }



}
