package GeTest;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Parent p = new Child("hi");
        Child p2 = new Child("hi");
//        System.out.println("p.getClass().getMethods() = " + p.getClass().getMethod("getStr1").invoke());
    }


}
