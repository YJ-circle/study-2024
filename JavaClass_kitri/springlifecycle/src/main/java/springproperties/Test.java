package springproperties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springproperties/config2.xml");
	        
	       System.out.println(ctx.getBean("myDao2"));
	       ctx.close();
	}

}
