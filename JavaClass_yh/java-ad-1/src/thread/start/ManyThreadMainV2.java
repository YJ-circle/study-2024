package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        log("main() start");
        HelloRunnable runnable = new HelloRunnable();
        
        //스레드 100개 생성하여 실행하기
        for(int i=0; i<100; i++){
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
