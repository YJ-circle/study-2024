package standardanno.impl;

import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl2 implements OrderDao{
	
	@Override
	public void createOrder() {
		System.out.println("Inside Order DAO createOrder()");
	}
	
	

}
