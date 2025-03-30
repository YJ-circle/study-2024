package thread.start;
import static util.MyLogger.log;

public class InnerRunnableMainV4 {
    public static void main(String[] args) {

        log("main() start");
        log("main() end");

        //람다 사용
        // 람다를 사용하면 메서드를 전달할 수 있다
        Thread thread = new Thread(() -> log("run()"));
        thread.start();
    }



}
