package autowire.annotation.backup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/autowire/annotation/autowire_anno.xml");
	        
	       System.out.println(ctx.getBean("emp"));
	       ctx.close();
	}

}
