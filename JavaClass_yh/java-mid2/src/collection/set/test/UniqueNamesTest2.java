package collection.set.test;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueNamesTest2 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        Set<Integer> set = new LinkedHashSet<>();
        for (Integer i : inputArr) {
            set.add(i);
        }
        System.out.println(set);

    }
}
