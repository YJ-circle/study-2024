package com.kitri.spring.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" == 프리 핸들러 == ");
		
		// URL 정보 가져오기
		System.out.println("URL = " + request.getRequestURL());
		
		// 호출 방식 출력
		System.out.println("method = " + request.getMethod());
		
		System.out.println();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(" == 포스트 핸들러 == ");
		System.out.println("시간 = " + modelAndView.getModel().get("today"));
		System.out.println();
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println(" == afterCompletion == ");
		
	}

}
