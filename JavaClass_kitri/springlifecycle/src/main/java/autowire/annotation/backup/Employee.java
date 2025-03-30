package autowire.annotation.backup;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	@Autowired
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [adress=" + address + "]";
	}
	
	
}
