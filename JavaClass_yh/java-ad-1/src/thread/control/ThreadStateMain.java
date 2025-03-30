package thread.control;
import static util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // 잠자고 있는 상태 TIMED_WAITING
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); // 끝난 상태 TERMINATED
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
            log("start");
            log("myThread.state2 = " + Thread.currentThread().getState());
            log("sleep() Start");
            Thread.sleep(3000);
            log("sleep() End");
            log("myThread.state4 = " + Thread.currentThread().getState()); // 깨고 나면 Runable
            log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
