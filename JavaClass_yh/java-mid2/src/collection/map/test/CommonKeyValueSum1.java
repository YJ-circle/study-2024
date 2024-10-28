package collection.map.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CommonKeyValueSum1 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 4);
        map2.put("C", 5);
        map2.put("D", 6);
        // 코드 작성
        List<String> result = new ArrayList<>();
        for (String s : map2.keySet()) {
            if (map1.containsKey(s)) {
                result.add(s + "= " + (map1.get(s) + map2.get(s)));
            }
        }
        System.out.println(result);
    }
}