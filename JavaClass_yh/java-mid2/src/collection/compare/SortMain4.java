package collection.compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortMain4 {
    public static void main(String[] args) {
        MyUser myuser1 = new MyUser("a", 30);
        MyUser myuser2 = new MyUser("b", 20);
        MyUser myuser3 = new MyUser("c", 10);
        List<MyUser> list = new LinkedList<>();

        list.add(myuser1);
        list.add(myuser2);
        list.add(myuser3);
        System.out.println("기본 데이터");
        System.out.println(list);

        System.out.println("Comparable 기본 정렬");
        list.sort(null);
//        Collections.sort(list);
        /*
        list.sort(null) 자바 1.8부터 사용
        별도의 비교자가 없으므로 Comparable로 비교해서 정렬

        Collections.sort (list, new IdCompartor())
        별도의 비교자를 가지고 정렬을 해야한다.
         */
        System.out.println(list);

        System.out.println("IDComparator 정렬");
        list.sort(new IdComparator());
        System.out.println(list);

    }
}
