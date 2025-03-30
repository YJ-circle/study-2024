package exception.basic.unchecked;

public class UncheckedThrowmain {
    public static void main(String[] args) {
        Service service = new Service();
        service.callThro();
        System.out.println("정상 종료");
    }
}
