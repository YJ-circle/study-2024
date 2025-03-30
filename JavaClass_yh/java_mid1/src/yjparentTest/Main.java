package yjparentTest;

public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();
        System.out.println(p);
        System.out.println("p.getClass() = " + p.getClass());
        Child q = getclass(p);
        q.child();
        System.out.println(p);


    }
    private static <T, E> T getclass(E p){

        return (T) p.getClass().cast(p);

    }
}
