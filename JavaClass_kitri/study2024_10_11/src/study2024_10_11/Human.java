package study2024_10_11;

public class Human {
	private String name;
	private Tool tool;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void cook(Animal animal) {
		System.out.println("Human Method: cook");
		tool.isUsed();
		animal.beEat();
		System.out.println(name + "이 " + "(도구: " + tool.getName() + ")로 " + "(동물: " + animal.getName() +")을 요리했습니다");
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	private Tool getTool() {
		return tool;
	}
}

