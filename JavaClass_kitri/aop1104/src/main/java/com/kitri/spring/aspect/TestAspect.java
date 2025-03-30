package com.kitri.spring.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.kitri.spring.aspect01.dto.Member;

@Aspect
@Component
public class TestAspect {
//	@Before("execution(* com.kitri.spring.aspect01..*(..))")
//    public void logBefore(JoinPoint joinPoint) {
//        // 호출된 메소드 이름을 가져옴
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("logBefore");
//    }
//	
//	@After("execution(* com.kitri.spring.aspect01..*(..))")
//	public void logAfter(JoinPoint joinPoint) {
//		// 호출된 메소드 이름을 가져옴
//		String methodName = joinPoint.getSignature().getName();
//		System.out.println("logAfter");
//	}
//	
    @AfterReturning(pointcut = "execution(* com.kitri.spring.aspect01..*(..))", returning = "results")
	public List<Member> logAfterReurnin(JoinPoint jointPoint, List<Member> results){
		System.out.println();
    	System.out.println("== log After Returning == ");
		int i = 0;

		for (Member member : results) {
			i++;
			member.setName("홍길동" + i);
			member.setEmail(member.getId() + "@test.com");
			member.setAddress("집주소" + i);
		}
		return results;
	}
}
