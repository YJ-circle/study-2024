package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

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
        List<String> shapeList = List.of("\u2660","\u2665","\u2666","\u2663");

        if(getNum() < obj.getNum()){
            return -1;
        }
        else if(getNum() > obj.getNum()){
            return 1;
        }

        else{
            if(shapeList.indexOf(getShape()) < shapeList.indexOf(obj.getShape())){
                return -1;
            }
            else if(shapeList.indexOf(getShape()) > shapeList.indexOf(obj.getShape())){
                return 1;
            }
            else {
                return 0;
            }
        }

    }
}
