package collection.map.test;

import java.util.*;
public class ItemPriceTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);
        Set<String> key = map.keySet();

        Set<String> result = new HashSet<>();
        for (String fruit : key) {
            if(map.get(fruit) == 1000){
                result.add(fruit);
            }
        }
        System.out.println(result);
    }
}