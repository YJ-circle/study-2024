package com.kitri.spring.aop;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.spring.aspect01.IProductService;
import com.kitri.spring.aspect01.ProductServiceImpl;
import com.kitri.spring.aspect01.dto.Member;

public class RunMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/com/kitri/spring/aop/"
						                         + "config.xml");
		
//		System.out.println("== Start ==");
//		System.out.println();
		IProductService svc = (IProductService) ctx.getBean("productSvc");
//		int multiply = svc.multiply(2, 2);
//		System.out.println("multiply = " + multiply);
		
		List<Member> members = svc.doSomething();
		for (Member member : members) {
			System.out.println(member);
		}
		
	}

}
