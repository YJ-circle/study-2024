package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain2 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        AnimalMethod.checkup(dog);
        System.out.println("END1");
        AnimalMethod.checkup(cat);
        System.out.println("END2");
        AnimalMethod.checkup(cat, cat);

        Dog targetDog = new Dog("큰 멍멍이", 200);
        System.out.println(AnimalMethod.bigger(dog, targetDog)); // 크기 비교
    }
}
