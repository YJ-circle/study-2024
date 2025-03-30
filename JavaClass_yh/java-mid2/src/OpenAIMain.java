import java.util.concurrent.*;

public class OpenAIMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exe = Executors.newFixedThreadPool(1);
        Future<String> future = exe.submit(new Task());
        String s = "";
        for (int i = 0; i < 300_000; i++) {
            s += "h";
            if(i == 300){
                System.out.println("future.toString() = " + future.toString());
            }

        }
        System.out.println("future.toString() = " + future.toString());
        exe.shutdown();

    }

    private static class AIQ{
        private static ExecutorService exe = Executors.newFixedThreadPool(1);
        public void q() throws ExecutionException, InterruptedException {
        Future<String> future = exe.submit(new Task());
        }

    }

    private static class Task implements Callable<String> {
        private static int count = 0;
        @Override
        public String call() throws Exception {
            System.out.println(++count);
            String s= "hi ";
            for (int i = 0; i < 300_000; i++) {
                s += "a";
            }
            return s;
        }
    }
}
