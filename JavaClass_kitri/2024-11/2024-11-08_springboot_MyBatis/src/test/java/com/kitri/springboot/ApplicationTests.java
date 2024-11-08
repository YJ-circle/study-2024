package com.kitri.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private ApplicationContext context;
	
	@Test
	void contextLoads() {
//		MemberDao dao = (MemberDao) context.getBean(MemberDao.class);
//		List<Member> findMemberAll = dao.findMemberAll();
//		System.out.println(findMemberAll);
		
	}

}
