package objectapplicable.dto;

public class TestDto1 {
	private int a;
	private String b;
	
	public TestDto1() {}
	public TestDto1(int a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
}
