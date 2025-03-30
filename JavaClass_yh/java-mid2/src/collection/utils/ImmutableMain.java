package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {
        //불변 리스트 생성

        List<Integer> list = List.of(1, 2, 3);

        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(4);
        System.out.println("mutableList = " + mutableList);
        System.out.println("mutableList class = " + mutableList.getClass());

        //다시 불변 리스트로

        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);

        //변경하려면 예외가 발생한다.
        System.out.println("unmodifiableList class = " + unmodifiableList.getClass());
    }
}
