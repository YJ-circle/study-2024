package autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	String name;
	
	@Autowired
	@Qualifier("reservation2")
	Reservation reservation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", reservation=" + reservation + "]";
	}



}
