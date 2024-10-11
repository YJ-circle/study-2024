package com.kitri.spring.springcore.wrapper;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/com/kitri/spring/springcore/wrapper/wrapper.xml");
		Student student = (Student) ctx.getBean("student");
		System.out.println(student);
		ctx.close();
		
	}
}
