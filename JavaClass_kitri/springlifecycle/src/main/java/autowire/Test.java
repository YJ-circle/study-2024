package autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/autowire/autowire2.xml");
	        
	       System.out.println(ctx.getBean("customer"));
	       ctx.close();
	}

}
