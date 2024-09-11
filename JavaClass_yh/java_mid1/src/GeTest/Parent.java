package GeTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Parent {

    default  <T> Object convert(Object s) throws InvocationTargetException, IllegalAccessException {
        Method[] m = s.getClass().getMethods();
        for (Method method : m) {
            Object result;
            result = method.invoke("","");
            return result;
        }
        return null;
    }
}
