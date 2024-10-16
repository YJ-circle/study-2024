package standardanno.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("bo")
public class OrderBoImpl2 implements OrderBo{
	@Autowired
	private OrderDao dao;
	@Override
	public void placeOrder() {
		System.out.println("Inside Order BO");
		dao.createOrder();
	}
	public OrderDao getDao() {
		return dao;
	}
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
	
	
	
}
