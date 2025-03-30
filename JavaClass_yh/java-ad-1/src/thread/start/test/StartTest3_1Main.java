package thread.start.test;

import static util.MyLogger.log;

public class StartTest3_1Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log((i+1) + "초");

            }
        }, "counter");
        thread.start();
    }

}
