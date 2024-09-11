package exception.basic.unchecked;

public class Service {
    Client client = new Client();
    public void callCatch() {
        try {
            client.call();
        } catch (MyUncheckedException e) {
            System.out.println("예외처리, Message= " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("정상 로직");
    }

    public void callThro() {
        client.call();
    }
}
