package com.spring.springorm.mybatis.mybatispractice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.springorm.mybatis.mybatispractice.dao.Member;
import com.spring.springorm.mybatis.mybatispractice.dao.MemberDaoImpl;

public class Main {
	private static ClassPathXmlApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/com/spring/springorm/mybatis/mybatispractice/config/config.xml");

        MemberDaoImpl memberDao = (MemberDaoImpl) ctx.getBean("memberDao");
        
        
        System.out.println("ID조회");
        String memberId = "id";
        Member member = memberDao.findMemberById(memberId);

        if (member != null) {
            System.out.println(member);
        } else {
            System.out.println("회원 정보를 찾을 수 없습니다.");
        }
        System.out.println("\n");
        
        System.out.println("전체 조회");
        System.out.println(memberDao.findMemberAll());
        System.out.println("\n");
        
        
        System.out.println("ID추가");
        Member newMember = new Member().setId("test")
        							.setName("이름")
        							.setPassword("pwd")
        							.setAddress("집주소");
        System.out.println(memberDao.addMember(newMember));
        ctx.close();
    }
}