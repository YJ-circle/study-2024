package innerbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerBeanMain {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/innerbean/innerbean.xml");
       Employee emp = (Employee) ctx.getBean("employee");
       System.out.println(emp);
       ctx.close();
    }
}
