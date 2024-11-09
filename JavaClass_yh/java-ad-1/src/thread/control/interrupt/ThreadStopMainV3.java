package thread.control.interrupt;

import static thread.control.ThreadUtils.sleep;
import static util.MyLogger.log;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);

        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();

        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        //runFlag제거
        //volatile boolean runFlag = true;

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 확인 : 변경 X
                log("작업 중");
            }
            
            //인터럽트 상태가 바뀌지 않음

            try {
                log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
                log("자원 정리");
                Thread.sleep(1000);
                log("작업 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }

        }
    }
}
