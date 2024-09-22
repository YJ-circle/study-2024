package collection.array;

public class MyArrayListV3BadMain {
    public static void main(String[] args) {
        MyArrayListV3 numberList = new MyArrayListV3();
        numberList.add(1);
        numberList.add(2);
        numberList.add("문자3");
        System.out.println("numberList = " + numberList);

        //꺼낼 때 Object를 반환하기때문에 다운 캐스팅 필요
        Integer num1 = (Integer) numberList.get(0);
        Integer num2 = (Integer) numberList.get(1);
        
        //ClassCastException 발생
        Integer num3 = (Integer) numberList.get(2); // 캐스팅 오류 

    }
}
