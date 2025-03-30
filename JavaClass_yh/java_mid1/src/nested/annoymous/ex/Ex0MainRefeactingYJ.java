package nested.annoymous.ex;

import nested.local.Printer;

public class Ex0MainRefeactingYJ {
    public static void print(String s){
        Printer printer = new Printer() {
            @Override
            public void print() {
                System.out.println("프로그램 시작");
                System.out.println(s);
                System.out.println("프로그램 종료");
            }
        };

        printer.print();
    }

    public static void main(String[] args) {
        print("Hello Java");
        print("Hello Spring");
    }


}
