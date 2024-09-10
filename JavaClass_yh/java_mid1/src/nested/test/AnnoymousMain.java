package nested.test;

public class AnnoymousMain {
    public static void main(String[] args) {
        Hello h = new Hello(){
            @Override
            public void hello() {
                System.out.println("Hello.hello");
            }
        };
        h.hello();
    }
}
