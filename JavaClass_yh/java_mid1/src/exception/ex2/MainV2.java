package exception.ex2;

import java.util.Scanner;

public class MainV2 {

    public static void main(String[] args) throws NetworkClientExceptionV2 {
//        NetworkSeviceV2_1 networkSevice = new NetworkSeviceV2_1();
//        NetworkSeviceV2_2 networkSevice = new NetworkSeviceV2_2();
//        NetworkSeviceV2_3 networkSevice = new NetworkSeviceV2_3();
//        NetworkSeviceV2_4 networkSevice = new NetworkSeviceV2_4();
        NetworkSeviceV2_5 networkSevice = new NetworkSeviceV2_5();
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
