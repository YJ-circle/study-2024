package nested.annoymous.ex;

import java.util.Random;

public class Ex1RefMainV5 {
    public static void hello(Process process){
        System.out.println("프로그램 시작");
        String s = "hi";
        process.run();
        System.out.println("프로그램 종료");
    }
    

    public static void main(String[] args) {
        //람다는 메서드를 던질 수 있게 됐다.
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;// 1~6까지
            System.out.println("주사위 = " + randomValue);
        });
        hello(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        });
    }
}
