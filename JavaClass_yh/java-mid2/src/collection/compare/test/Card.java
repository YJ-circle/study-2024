package collection.compare.test;

public class Card implements Comparable{
    private String shape;
    private int num;

    public Card(String shape, int num) {
        this.shape = shape;
        this.num = num;
    }

    @Override
    public String toString() {
        return num + "(" + shape + ")";
    }

    public String getShape() {
        return shape;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Object o) {
        Card obj = (Card) o;
        return getNum() < obj.getNum() ? -1 : (getNum() == obj.getNum() ? 0 : 1);
    }
}
