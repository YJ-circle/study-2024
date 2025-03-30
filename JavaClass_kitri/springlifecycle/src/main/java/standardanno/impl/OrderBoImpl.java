package standardanno.impl;

public class OrderBoImpl implements OrderBo{
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
