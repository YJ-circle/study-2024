package collection.set.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {
        public static void main(String[] args) {
            /* 해답
            addAll: 합집합 +
            retain메소드: 교집합
            removeAll : 차집합
             */

            Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
            Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));
            System.out.println("합집합");
            Set<Integer> result1 = new HashSet<>();
            result1.addAll(set1);
            result1.addAll(set2);
            System.out.println("합집합= " + result1);

            System.out.println("교집합");
            Set<Integer> result2 = new HashSet<>();
            for (Integer i : set1) {
                if(set2.contains(i)){
                    result2.add(i);
                }
            }
            System.out.println("교집합 = " + result2);

            System.out.println("차집합");
            Set<Integer> result3 = new HashSet<>();
            for (Integer i : set1) {
                if(!set2.contains(i)){
                    result3.add(i);
                }
            }
            System.out.println("차집합 = " + result3);

        }
}
