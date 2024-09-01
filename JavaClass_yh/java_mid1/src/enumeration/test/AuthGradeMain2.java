package enumeration.test;

import enumeration.test.AuthGrade;

import java.util.Scanner;

public class AuthGradeMain2 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("당신의 등급을 입력하세요 [GUEST, LOGIN, ADMIN] : ");
            String text = sc.nextLine();
            AuthGrade grade = AuthGrade.valueOf(text.toUpperCase());
            System.out.println("당신의 등급은 " + grade.getDescription() + "입니다.");
            grade.printMenu();
            System.out.println();
            System.out.println();

        }
    }
}
