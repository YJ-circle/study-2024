package com.kitri.spring.springcore.task;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.spring.springcore.task.Item;
import com.kitri.spring.springcore.task.ShoppingCart;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:/com/kitri/spring/springcore/task/shoppingCart.xml");

		List<Item> item = ((ShoppingCart)ctx.getBean("shoppingCart")).getItemList();
		for(Item item2 : item) {
			System.out.println(item2);
		}
		ctx.close();
		
	}
}
