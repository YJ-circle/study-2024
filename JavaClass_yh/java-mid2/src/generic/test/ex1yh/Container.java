package generic.test.ex1yh;

public class Container<T> {
    private T item;



    public void setItem(T data1) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public boolean isEmpty() {
        return item == null;
    }
}
