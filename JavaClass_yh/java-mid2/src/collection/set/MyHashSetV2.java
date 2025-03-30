package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV2 {
    static final int DEFAULT_INITAL_CAPACITY = 10; // 먼저 만드는 배열의 크기 (최초 크기)
    //너무 작으면 Hash충돌이 잦다.


    private LinkedList<Object>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITAL_CAPACITY;

    public MyHashSetV2() {
        initBuckets();
    }

    public MyHashSetV2(int capacity) {
        this.capacity = capacity;
        initBuckets();
    }

    private void initBuckets() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(Object value) {
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }

        bucket.add(value);
        size++;
        return true;
    }

    public boolean contains(Object searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Object> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }

    public boolean remove(Object value) {
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        // 그냥 숫자를 넣으면 인덱스 위치가 삭제 된다. (주의!)
        // 래퍼클래스로 박싱해서 넣어준다.
        boolean result = bucket.remove(value);
        if (result) {
            size--;
            return true;
        } else {return false;}
    }
    private int hashIndex(Object value) {
        //Math.abs : 절대값 구하기
        return Math.abs(value.hashCode()) % capacity;
    }
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV2{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
