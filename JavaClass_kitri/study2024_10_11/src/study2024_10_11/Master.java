package study2024_10_11;

public class Master {
	private static Human human;
	private static Animal animal;
	private static Tool tool;
	
	public static void main(String[] args) {
		
		// 사람 고용
		human = new Human();
		human.setName("홍길동");
		
		animal = new Animal();
		animal.setName("야생동물");
		
		tool = new Tool();
		tool.setName("장미칼");
		
		human.setTool(tool);
		
		//사람이 요리를 한다.
		human.cook(animal);
		
		
		
		
	}
}
