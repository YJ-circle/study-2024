package thread.control.interrupt;

import static thread.control.ThreadUtils.sleep;
import static util.MyLogger.log;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);

        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();

        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        //runFlag제거
        //volatile boolean runFlag = true;

        @Override
        public void run() {
            try {
                while (true) {
                    log("작업 중");
                    Thread.sleep(3000); // <- 여기서만 인터럽트 발생 sleep이 인터럽트를 발생시킨다.
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message" + e.getMessage());
                log("state= " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");
        }
    }
}
