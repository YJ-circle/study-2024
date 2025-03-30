package thread.start;
import static util.MyLogger.log;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {

        log("main() start");
        log("main() end");
        MyRunnable runnabe = new MyRunnable();
        Thread thread = new Thread(runnabe);
        thread.start();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log("run()");
        }
    }


}
