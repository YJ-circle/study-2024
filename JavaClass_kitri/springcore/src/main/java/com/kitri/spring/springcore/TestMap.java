package com.kitri.spring.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMap {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/com/kitri/spring/springcore/mapConfig.xml");
		Product3 product = (Product3) ctx.getBean("map");
		System.out.println(product);
		ctx.close();
		
	}
}
