package generic.ex4;

import generic.animal.Animal;

public class ComplexBox <T extends Animal>{
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }
    //제너릭을 2개 선언에서 문제 없다.
//    public <Z> Z printAndReturn (Z z) {
//        System.out.println("animal.className: " + animal.getClass().getName());
//        System.out.println("t.className: " + z.getClass().getName());
//        return z;
//    }


    //T제너릭이 2개이다. 어떤게 우선일까
    // 제너릭 타입 > 제너릭 메서드
    public <T> T printAndReturn (T z) {
        System.out.println("animal.className: " + animal.getClass().getName());
        System.out.println("t.className: " + z.getClass().getName());
        return z;
    }
}
