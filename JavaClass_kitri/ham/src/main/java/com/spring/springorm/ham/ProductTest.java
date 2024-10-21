package com.spring.springorm.ham;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductTest {
	private static ClassPathXmlApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/config/config.xml");
		
		ProductDao dao = (ProductDao) ctx.getBean("productDao");
		
		System.out.println("전체 상품 조회");
		System.out.println(dao.findAll());
		System.out.println("상품 조회");
		System.out.println(dao.find(2));
		System.out.println("결과 = " + 
				dao.create(new Product()
				   .setId(5)
				   .setName("ORM테스트")
				   .setPrice(30_000)
				   .setCategory("테스트")
				   .setStock(200)
				   ));
		dao.update(new Product()
		   .setId(5)
		   .setName("ORM테스트22")
		   .setPrice(300_000)
		   .setCategory("테스트")
		   .setStock(200)
		   );
		dao.delete(new Product().setId(7));

		
		ctx.close();
	}
}
