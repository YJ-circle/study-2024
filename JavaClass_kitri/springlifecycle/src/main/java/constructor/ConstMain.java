package constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstMain {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/constructor/constructor.xml");
       Employee emp = (Employee) ctx.getBean("employee");
       System.out.println(emp);
       ctx.close();
       
    }
}
