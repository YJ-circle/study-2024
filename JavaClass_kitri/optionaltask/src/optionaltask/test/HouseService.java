package optionaltask.test;

import java.util.Optional;

public class HouseService {
	public House setOwner(House house, String name) {
		house.setOwner(Optional.of(new Person(name)));
		return house;
	}
	
	public House setAddress(House house, String address) {
		house.setAddress(Optional.of(address));
		return house;
	}
	
	public String getOwnerName(House house) {
		
		return house.getOwner().orElse(new Person("주인없음"))
			                   .getName();
				                
	}
	
	public String getAddress(House house) {
		return house.getAddress().orElse("주소 없음");
	}
}
