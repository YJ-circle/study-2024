package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main_YH {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintWork(500), "0.5초 카운터");
        Thread thread2 = new Thread(new PrintWork(1000), "1초 카운터");

        thread1.start();
        thread2.start();


    }
    static class PrintWork implements Runnable{
        private int sleepMs;

        public PrintWork(int sleepMs) {
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            int i = 0;

            while(true){
                try {
                    log(i + "초");
                    Thread.sleep(sleepMs);
                    i+=sleepMs;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
