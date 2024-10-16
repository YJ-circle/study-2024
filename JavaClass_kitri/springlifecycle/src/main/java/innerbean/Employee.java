package innerbean;

import org.springframework.beans.factory.annotation.Required;

public class Employee {
	private int id;
	private Address address;
	
	@Required
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", adress=" + address + "]";
	}
	
	
}
