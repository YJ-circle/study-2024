package thread.start.test;
import static util.MyLogger.log;
public class StartTest1Main {
    public static void main(String[] args) {
        Thread thread = new CounterThread();
        thread.start();
    }
    static class CounterThread extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log((i+1) + "초");

            }

        }
    }
}
