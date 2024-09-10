package nested.test;

public class OuterClass1Main {
    public static void main(String[] args) {
        OuterClass1.innerClass innerClass = new OuterClass1().new innerClass();
        innerClass.hello();
    }
}
