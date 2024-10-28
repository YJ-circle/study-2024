package collection.map.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, String> dict = new HashMap<>();
    public static void main(String[] args) {
        inputWord(sc);
        searchWord(sc);

        sc.close();
    }

    private static void searchWord(Scanner sc) {
        while (true){
            System.out.print("찾을 영어 단어를 입력하세요 종료는 q : ");
            String key = sc.nextLine();
            if(key.equals("q")){
                return;
            }

            if (dict.containsKey(key)) {
                System.out.println(key + "의 뜻: " + dict.get(key));
                continue;
            }

            System.out.println(key + "은(는) 사전에 없는 단어입니다.");

        }

    }

    private static void inputWord(Scanner sc) {
        while (true){
            System.out.print("영어 단어를 입력하세요 종료는 q: ");
            String key = sc.nextLine();
            if(key.equals("q")){
                return;
            }
            System.out.print("한글 뜻 입력하세요: ");
            String value = sc.nextLine();
            dict.put(key, value);
        }

    }

}
