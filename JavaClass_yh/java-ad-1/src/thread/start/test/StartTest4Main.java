package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                int i = 0;
                while(true){
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log((++i) + "초");
                }
            }
        }, "1초 카운터");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                while(true){
                    double d = 0.0;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    d += 0.5;
                    log(d + "초");

                }
            }
        }, "0.5초 카운터");
        thread2.start();
    }

}
