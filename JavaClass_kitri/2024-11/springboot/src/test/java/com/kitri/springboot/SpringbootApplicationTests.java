package com.kitri.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.Provider.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.kitri.springboot.service.Services;

@SpringBootTest
class SpringbootApplicationTests {
	@Autowired
	ApplicationContext context;
	@Test
	void contextLoads() {
		Services svc = (Services) context.getBean(Services.class);
		svc.hello();
	}

}
