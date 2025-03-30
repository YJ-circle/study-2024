package thread.control;

import static thread.control.ThreadUtils.*;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new CheckedRunnable());
        thread.start();
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {
        @Override
        public void run(){
            sleep(1000);
        }
    }
}
