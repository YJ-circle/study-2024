package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DequeQueueMain {
    public static void main(String[] args) {
        // 큐는 큐 인터페이스가 있는데 Stack은 인터페이스가 제공되진 않는다.
        Queue<Integer> deque = new ArrayDeque<>();


        //데이터 추가
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque);

        //다음꺼낼데이터 확인
        System.out.println("deque.peek() = " + deque.peek());

        // 데이터 꺼내기
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println(deque);
    }
}
