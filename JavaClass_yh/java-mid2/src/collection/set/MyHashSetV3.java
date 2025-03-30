package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV3<E> implements MySet<E>{
    static final int DEFAULT_INITAL_CAPACITY = 10; // 먼저 만드는 배열의 크기 (최초 크기)

    private LinkedList<E>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITAL_CAPACITY;

    public MyHashSetV3() {
        initBuckets();
    }

    public MyHashSetV3(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(E searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<E> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    public boolean remove(E value) {
        int hashIndex = hashIndex(value);
        LinkedList<E> bucket = buckets[hashIndex];
        // 그냥 숫자를 넣으면 인덱스 위치가 삭제 된다. (주의!)
        // 래퍼클래스로 박싱해서 넣어준다.
        boolean result = bucket.remove(value);
        if (result) {
            size--;
            return true;
        } else {return false;}
    }
    private int hashIndex(E value) {
        //Math.abs : 절대값 구하기
        return Math.abs(value.hashCode()) % capacity;
    }
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV3{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
