package standardanno.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
	       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/standardanno/impl/order.xml");
	       OrderBo bean = (OrderBo) ctx.getBean("bo");
	       bean.placeOrder();
	       ctx.close();
	}
}
