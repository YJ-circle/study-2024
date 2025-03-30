package yjparentTest;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test2 {
    public Integer[] solution(int[] arr, int divisor) {

        TreeSet<Integer> tempInt = new TreeSet<>();
        for (int i = 0; i < arr.length; i++){
            if(isMultiple(arr[i], divisor) > 0){
                tempInt.add(arr[i]);
            }
        }


        Integer[] answer = tempInt.toArray(new Integer[tempInt.size()]);
        return answer;
    }

    private int isMultiple(int num, int divisor){
        int multi = divisor;
        while(true){
            if(num == multi){
                return num;
            } else {
                if(num > multi){
                    multi += divisor;
                } else {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] i = {1,2,6,7,9,22};
        for (int i1 : test2.solution(i, 2)) {
            System.out.println("i1 = " + i1);
        }


    }
}