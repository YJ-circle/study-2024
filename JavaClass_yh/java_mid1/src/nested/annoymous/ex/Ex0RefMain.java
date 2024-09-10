package nested.annoymous.ex;

public class Ex0RefMain {

    public static void hello(String s){
        System.out.println("프로그램 시작");
        System.out.println(s);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        //변하는 부분을 메서드 내부에서 가지고 있는 것이 아니라 외부에서 전달받는다.
        hello("Hello Java");
        hello("Hello Spring");
    }
}
