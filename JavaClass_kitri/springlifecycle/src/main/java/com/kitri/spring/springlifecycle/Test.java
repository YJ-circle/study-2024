package com.kitri.spring.springlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springbasic/anotation.xml");
//      ApplicationContext로도 받을 수 있음
//       ApplicationContext ctx = 
//    		   new ClassPathXmlApplicationContext("classpath:/springbasic/lifecycle.xml");

      
       Patient patient = (Patient) ctx.getBean("patient");
       System.out.println("patient = " + patient);
       ctx.close();
    }
}
