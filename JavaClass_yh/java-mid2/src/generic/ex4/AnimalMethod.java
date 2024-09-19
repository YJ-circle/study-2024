package generic.ex4;

import generic.animal.Animal;
import generic.animal.Cat;

public class AnimalMethod {
    public static <T extends Animal>
                   void checkup(T t) {
        System.out.println("동물 이름: " + t.getName());
        System.out.println("동물 이름: " + t.getSize());
        t.sound();
    }

    public static <T extends Animal, E extends Cat>
                   void checkup(T t, E e) {
        System.out.println("동물 이름: " + t.getName());
        System.out.println("동물 이름: " + t.getSize());
        t.sound();
        e.cat();
    }

    public static <T extends Animal> T bigger(T t1, T t2) {
        return t1.getSize() > t2.getSize() ? t1 : t2;
    }
}
