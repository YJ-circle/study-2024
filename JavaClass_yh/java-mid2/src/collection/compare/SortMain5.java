package collection.compare;

import java.util.TreeSet;

public class SortMain5 {
    public static void main(String[] args) {
        MyUser myuser1 = new MyUser("a", 30);
        MyUser myuser2 = new MyUser("b", 20);
        MyUser myuser3 = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(myuser1);
        treeSet1.add(myuser2);
        treeSet1.add(myuser3);
        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet1);

        TreeSet<MyUser> treeSet2 = new TreeSet<MyUser>(new IdComparator());
        treeSet2.add(myuser1);
        treeSet2.add(myuser2);
        treeSet2.add(myuser3);
        System.out.println("IDComparator 정렬");
        System.out.println(treeSet2);
    }
}
