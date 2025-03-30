package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("n개의 정수를 입력하세요: (종료 0)");
        while (true) {
            int i = sc.nextInt();
            if(i==0){
                break;
            }
            System.out.println();
            list.add(i);

        }
        int sum = 0;
        double avg = 0;
        for (Integer i : list) {
            sum += i;
        }
        avg = (double) sum/list.size();
        System.out.println("합계 = " + sum);
        System.out.println("평균 = " + avg);
    }
}
