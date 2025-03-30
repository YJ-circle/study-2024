package collection.iterable;

import java.util.Iterator;

public class MyArrayMain {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{1,2,3,4});
        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
        }

        //추가
        //Iterable 인터페이스를 구현하였기 때문에 향상된 for문을 사용할 수 있게 된다.
        System.out.println("for-each 사용");
        for(int value : myArray){
            System.out.println("value = " + value);
        }
    }
}
