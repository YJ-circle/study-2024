package kitri.spring.javabean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kitri.spring.javabean.dao.OrderDao;
import kitri.spring.javabean.dao.UserDao;

@Configuration
public class DaoConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public UserDao userDao() {
		return new UserDao();
	}
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public OrderDao OrderDao() {
		return new OrderDao();
	}
	
}
