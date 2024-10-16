package standardanno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/standardanno/config.xml");
	       System.out.println(ctx.getBean("instructor"));
	       ctx.close();
	}

}
