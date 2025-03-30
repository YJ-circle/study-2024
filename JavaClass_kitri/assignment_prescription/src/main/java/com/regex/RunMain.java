package com.regex;

public class RunMain {
public static void main(String[] args) {
    String str1 = "123"; // 세 자리 숫자
    String str2 = "12";  // 두 자리 숫자
    String str3 = "1234"; // 네 자리 숫자
    String str4 = "abc";  // 문자

    // 정규 표현식 [0-9]{3}를 사용하여 세 자리 숫자인지 확인
    System.out.println(str1.matches("[0-9]{3}")); // true
    System.out.println(str2.matches("[0-9]{3}")); // false
    System.out.println(str3.matches("[0-9]{3}")); // false
    System.out.println(str4.matches("[0-9]{3}")); // false
}
}
