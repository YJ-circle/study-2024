package com.kitri.spring.javawebbean.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration 
	implements WebApplicationInitializer {

private static AnnotationConfigWebApplicationContext actx = null;

@Override
public void onStartup(ServletContext servletContext) 
	throws ServletException {
	System.out.println("서블렛");
	actx = new AnnotationConfigWebApplicationContext();
	// 스프링컨테이너 설정 클래스 파일
	actx.register(SpringConfig.class);

	// 디스패처 서블릿 설정
	ServletRegistration.Dynamic servlet =
			servletContext.addServlet("dispatcher", 
				new DispatcherServlet(actx));
	servlet.setLoadOnStartup(1);
	servlet.addMapping("/");
	
//	actx.close();
	}

}
