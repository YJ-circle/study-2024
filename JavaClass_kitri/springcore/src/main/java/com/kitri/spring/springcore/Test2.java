package com.kitri.spring.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/com/kitri/spring/springcore/setConfig.xml");
		Product2 product = (Product2) ctx.getBean("productList");
		System.out.println(product);
		ctx.close();
		
	}
}
