package com.spring.studydb;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.studydb.entity.GoodsEntity;
import com.spring.studydb.service.IGoodsSvc;


public class RunMain {
	
	public static void main(String[] args) throws SQLException {
	       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/com/spring/studydb/config/config.xml");
	       IGoodsSvc goodsSvc = (IGoodsSvc) ctx.getBean("goodsSvc");
	       
	       // 데이터 가져오기
	       List<GoodsEntity> goodsList = goodsSvc.getGoodsList();
	       System.out.println(goodsList);
	       
	       // 데이터 추가
	      
	       String goodscd = "오슬";
	       String goodsnm = "좋은 상품";
	       int price = 10_000;
	       
	       int insertRow = goodsSvc.insertGoods(goodscd, goodsnm, price);
	       System.out.println("추가된 행 = " + insertRow);
	       ctx.close();
		
	}
	
}
