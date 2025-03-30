package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("==My Array List 추가==");
        addFirst(new ArrayList<>(), size);
        addMid(new ArrayList<>(), size);

        ArrayList<Integer> arrayList = new ArrayList<>();
        addLast(arrayList, size);
        int loop = 10000;
        System.out.println("==Array List 조회==");
        getIndex(arrayList, loop, 0);
        getIndex(arrayList, loop, size/2);
        getIndex(arrayList, loop, size-1);

        System.out.println("==Array List 검색==");
        search((arrayList), loop, 0);
        search((arrayList), loop, size/2);
        search((arrayList), loop, size-1);

        System.out.println("==Linked List 추가==");
        addFirst(new LinkedList<>(), size);
        addMid(new LinkedList<>(), size);

        LinkedList<Integer> linkedList = new LinkedList<>();
        addLast(linkedList, size);
        System.out.println("==Linked List 조회==");
        getIndex(linkedList, loop, 0);
        getIndex(linkedList, loop, size/2);
        getIndex(linkedList, loop, size-1);

        System.out.println("==Linked List 검색==");
        search((linkedList), loop, 0);
        search((linkedList), loop, size/2);
        search((linkedList), loop, size-1);



    }

    private static void addFirst(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");

    }

    private static void addMid(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i/2, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("평균 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");

    }
    private static void addLast(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("마지막에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");

    }

    private static void getIndex(List<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index; "+ index + ", 반복; " + loop + "걸린 시간: " + (endTime - startTime)+ "ms");
    }

    private static void search(List<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.indexOf(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index; "+ findValue + ", 반복; " + loop + "걸린 시간: " + (endTime - startTime)+ "ms");
    }
}
