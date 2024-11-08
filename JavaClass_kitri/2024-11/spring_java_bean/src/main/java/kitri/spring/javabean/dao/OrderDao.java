package kitri.spring.javabean.dao;

import java.util.List;

import kitri.spring.javabean.dto.OrderDto;

public class OrderDao {
		public List<OrderDto> getOrderList(){
			return List.of(
					new OrderDto("order1", "주문1"),
					new OrderDto("order2", "주문2"));
	}

		public void init() {
			System.out.println("Order Dao Init");
		}
		
		public void destroy() {
			System.out.println("Order Dao destroy");	
		}
		
}
