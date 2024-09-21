package generic.test.ex2;

import java.io.File;

public class SoluMain {
    public static void main(String[] args) {
        File file = new File("");
        String rootPath = String.valueOf(file.getAbsoluteFile());
        System.out.println("현재 프로젝트의 경로 : "+rootPath );


    }
}
