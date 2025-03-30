package com.spring.studydb;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.studydb.config.BeanFactory;
import com.spring.studydb.dto.GoodsDto;
import com.spring.studydb.service.IGoodsSvc;


public class RunMain {
	
	public static void main(String[] args) throws SQLException {
			  new BeanFactory("classpath:/com/spring/studydb/config/config.xml");
			  IGoodsSvc goodsSvc = BeanFactory.getSvcBean();

			  
			  String goodscd = "오슬"; String goodsnm = "좋은 상품"; int price = 10_000;
			  
			  int insertRow = goodsSvc.insertGoods(goodscd, goodsnm, price);
			  System.out.println("추가된 행 = " + insertRow);
			 
			  int updateRow = goodsSvc.updatePriceByName("좋은 상품", 20_000);
			  System.out.println("업데이트 된 행 = " + updateRow);
			 
			  int deleteRow = goodsSvc.deleteByName("좋은 상품");
			  System.out.println("삭제된 행 = " + deleteRow);
			  
			  int deleteRow2 = goodsSvc.deleteByName("좋은 상품22");
			  System.out.println("삭제된 행 = " + deleteRow2);
			  
			  /* 모두 조회 */
			  
			  System.out.println("전체 상품 조회");
			  List<GoodsDto> goodsList = goodsSvc.read();
			  for (GoodsDto goodsDto : goodsList) {
				System.out.println(goodsDto);
			   }
			  
			  /* 카테고리 조회 */ 
			  System.out.println();
			  System.out.println("공장이 '오슬' 제품 조회");
			  List<GoodsDto> goodsList2 = goodsSvc.readByCategory("오슬");
			  for (GoodsDto goodsDto : goodsList2) {
					System.out.println(goodsDto);
				}
			  
			  System.out.println();
			  System.out.println("제품명이 [웬유무브] 오버사이즈 나일론 스냅 자켓 조회");
			  String selectName = "[웬유무브] 오버사이즈 나일론 스냅 자켓";
			  System.out.println(goodsSvc.read(selectName));
			  BeanFactory.close();
			  
//			  
//			  // 데이터 가져오기 List<GoodsEntity> goodsList = goodsSvc.getGoodsList();
//			  System.out.println(goodsList);
//			  
			  // 데이터 추가
	       	/* 스프링 db 템플릿 테스트
	       	 * 
	       	 * 	       
	       JdbcTemplate jdbc = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	       String sql = "INSERT INTO product (FACTORY, NAME, PRICE) VALUES (?, ?, ?)";
	       int result = jdbc.update(sql, "오슬", "좋은 상품", 10_000);
	       System.out.println("영향 받은 행 = " + result);
	       	 */
	       
	       
	       
		
	}
	
}
