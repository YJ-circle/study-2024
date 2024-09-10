package nested.annoymous.ex;

import nested.local.Printer;

import java.util.Random;

public class Ex1MainYJ {
    public static void main(String[] args) {
        hello(1);
        hello(2);
    }
    public static void hello(int i){
        Printer printer = new Printer() {

            @Override
            public void print() {
                //코드조각 시작
                if(i==1){
                    int randomValue = new Random().nextInt(6) + 1;// 1~6까지
                    System.out.println("주사위 = " + randomValue);
                } else{
                    for (int i = 0; i < 3; i++) {
                        System.out.println("i = " + i);
                    }
                }
            }
        };
        System.out.println("프로그램 시작");
        printer.print();
        System.out.println("프로그램 종료");




        }
}

