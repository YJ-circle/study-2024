package university;


public class Location {
	private int x;
	private int y;
	Address address;
	
	
	public Location(Address address, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.address = address;
	}


	public int getX() {
		return x;
	}
	

	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + ", address=" + address + "]";
	}


	
	

}
