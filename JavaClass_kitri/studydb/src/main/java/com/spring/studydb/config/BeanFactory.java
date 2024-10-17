package com.spring.studydb.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.service.IGoodsSvc;

public class BeanFactory {
	private static  ClassPathXmlApplicationContext ctx;
	
	public BeanFactory(String path) {
		ctx = new ClassPathXmlApplicationContext(path);
	}
 		   
	
	static public GoodsDto getDtoBean() {
		 return (GoodsDto) ctx.getBean("dto");
		 Arrays.asList(null)
	}
	
	static public IGoodsSvc getSvcBean() {
		 return (IGoodsSvc) ctx.getBean("goodsSvc");
	}
	
	static public void close() {
		ctx.close();
	}
}
