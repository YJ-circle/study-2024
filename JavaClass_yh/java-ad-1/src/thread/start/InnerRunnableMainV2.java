package thread.start;
import static util.MyLogger.log;

public class InnerRunnableMainV2 {
    public static void main(String[] args) {

        log("main() start");
        log("main() end");

        //익명 클래스 사용하기
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }



}
