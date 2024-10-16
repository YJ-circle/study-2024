package com.kitri.spring.springlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInterface {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springbasic/interface.xml");
      
       PatientInterface patient = (PatientInterface) ctx.getBean("patient");
       System.out.println("patient interface = " + patient);
       ctx.close();
    }
}
