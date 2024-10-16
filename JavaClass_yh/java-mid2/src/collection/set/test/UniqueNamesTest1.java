package collection.set.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueNamesTest1 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        /*
        여러 정수가 입력된다. 여기서 중복 값을 제거하고 값을 출력해라.
        30, 20, 20, 10, 10이 출력되면 중복을 제거하고 출력하면 된다. 출력 순서는 관계없다.
        출력 예): 30, 20, 10 또는 10, 20, 30 또는 20, 10, 30등과 같이 출력 순서는 관계 없다.
         */

        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(inputArr));
        System.out.println(set);

        //해답
        Set<Integer> result = new HashSet<>();
        for (Integer i : inputArr) {
            result.add(i);
        }
        System.out.println(result);


        // 추천코드
        Set<Integer> gpt1 = new HashSet<>(Arrays.asList(inputArr));
        System.out.println(gpt1);

        Set<Integer> gpt2 = new HashSet<>();
        Collections.addAll(gpt2, inputArr);
        System.out.println(gpt2);

        // 스트림 : 변환, 필터링에 유리하다... 성능은 ?
        Set<Integer> gpt3 = Arrays.stream(inputArr).collect(Collectors.toSet());
        System.out.println(gpt3);
    }
}
