package kitri.spring.javabean.dto;

public class OrderDto {
	private String id;
	private String order;
	public OrderDto(String id, String order) {
		super();
		this.id = id;
		this.order = order;
	}
	
	public String getId() {
		return id;
	}
	public String getOrder() {
		return order;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", order=" + order + "]";
	}
	
	
}
