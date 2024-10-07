package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStackMain {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        //데이터 추가

        //Stack은 성능이 안좋고 하위호환을 위해 남아만 있다.
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);

        deque.peek();
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
    }
}
