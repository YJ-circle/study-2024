package university;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/university/university.xml");
       University univ = (University) ctx.getBean("university");
       System.out.println(univ);
       ctx.close();
       
       Integer integer = Integer.valueOf(2);
       
    }
}
