package collection.map.test;
import java.util.HashMap;
import java.util.Map;
public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        String[] splitText = text.split(" ");
        Map<String, Integer> result = new HashMap<>();
        for (String s : splitText) {
            result.put(s, result.getOrDefault(s, 0) + 1);
        }
        System.out.println(result);
    }
}