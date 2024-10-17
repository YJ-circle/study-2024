package collection.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmptyListMain {
    public static void main(String[] args) {
        //빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        //빈 불변 리스트 생성
        List<Integer> list3 = Collections.emptyList();//자바5
        List<Integer> list4 = List.of(); //자바9

        System.out.println("list3 = " + list3.getClass());
        System.out.println("list4 = " + list4.getClass());

        List<Integer> list5 = Arrays.asList(1, 2, 3);
        List<Integer> list6 = List.of(1, 2, 3);

        // 배열 -> List
        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> arrList = Arrays.asList(arr);
        /* 배열을 그대로 사용 (참조값을 가져가기때문에 값을 바꾸면 기존의 값도 변경된다)
           크기가 큰 배열을 그대로 가져다 쓰는 경우 성능에서 이점을 얻을 수 있다.
         */
        arrList.set(0, 100);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arrList = " + arrList);

        List<Integer> list = List.of(arr);
        /* 하나씩 들어가서 새로운 배열을 만든다. */
        


    }
}
