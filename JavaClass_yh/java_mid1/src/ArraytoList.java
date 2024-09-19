import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraytoList {
    public static void main(String[] args) {
        String[] strArray = {"1", "2", "3"};
        List<String> strList = Arrays.asList(strArray);
        System.out.println(strList);
        System.out.println("strArray = " + strArray);
        String[] two = new String[3];
        System.arraycopy(strArray, 0, two, 0, strList.size());
        System.out.println("two = " + two);

    }
}
