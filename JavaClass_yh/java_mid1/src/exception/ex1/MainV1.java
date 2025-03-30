package exception.ex1;
import java.util.Scanner;

public class MainV1 {

    public static void main(String[] args) {
//        NetworkSeviceV1_1 networkSevice = new NetworkSeviceV1_1();
//        NetworkSeviceV1_2 networkSevice = new NetworkSeviceV1_2();
        NetworkSeviceV1_3 networkSevice = new NetworkSeviceV1_3();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("전송할 문자: ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
            networkSevice.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}
