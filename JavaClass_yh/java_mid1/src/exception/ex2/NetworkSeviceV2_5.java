package exception.ex2;
public class NetworkSeviceV2_5 {

    public void sendMessage(String data){
        String address = "http://example.com";
        NetworkClientV2 client = new NetworkClientV2(address);

        client.initError(data);
        try {
            client.connect();
            client.send(data);

        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        } finally {
            // 해결할 수 없는 오류가 발생하더라도 예외 가능!
            client.disconnect();
        }
    }
}
