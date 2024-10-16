package university;


public class Address {
	private String street;
	private String city;
	private int id;
	
	


	public Address(String street, String city, int id) {
		super();
		this.street = street;
		this.city = city;
		this.id = id;
	}
	
	public Address(String street,  int id, String city) {
		super();
		this.street = street;
		this.city = city;
		this.id = id;
	}
	

	public Address(int id, String city, String street) {
		this.street = street;
		this.city = city;
		this.id = id;
	}
	

	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", id=" + id + "]";
	}
	
	
	
	
	
	
}
