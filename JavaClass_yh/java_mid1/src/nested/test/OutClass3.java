package nested.test;

public class OutClass3 {
    public void myMethod(){
        class LocalClass{
            public void hello() {
                System.out.println("LocalClass.hello");
            }
        }
        new LocalClass().hello();
    }
}
