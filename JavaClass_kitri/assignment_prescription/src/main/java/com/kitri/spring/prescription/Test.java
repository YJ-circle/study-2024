package com.kitri.spring.prescription;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext ctx =
    			new ClassPathXmlApplicationContext("classpath:/com/kitri/spring/prescription/config.xml");
    	
		System.out.println(ctx.getBean("prescription"));
    	
    	// 스프링 컨테이너 생성 후 빈 생성: Doctor/Patient/Prescription
    	
    	// 빈 객체 얻어오기: Prescription
    	
    	// Prescription 객체 출력
    	/*** 
    	 * 출력 형식
    	 * <<의사 정보>>
    	 * 의사명:			병원명:
    	 * 진료과:			경력기간:
    	 * 
    	 * =====================================
    	 * <<환자 정보>>
    	 * 환자명:			주소:
    	 * 병명:			치료기간:
    	 * 
    	 * =====================================
    	 * <<처방 내역>>
    	 * 처방약:			일일복용횟수:
    	 * 주의사항:
    	 * 처방기간:
    	 */
    }
}
