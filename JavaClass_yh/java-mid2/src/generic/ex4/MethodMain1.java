package generic.ex4;

public class MethodMain1 {
    public static void main(String[] args) {
        Integer i = 10;
        Object i1 = GenericMethod.objMethod(i);

        //타입 인자 (Type Argument) 명시적 전달
        System.out.println("명시적 타입 인자 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        System.out.println("result = " + result);

        Integer i2 = GenericMethod.numberMethod(20);
        System.out.println("i2 = " + i2);

        Double v = GenericMethod.numberMethod(20.2);
        System.out.println("v = " + v);
    }
}
