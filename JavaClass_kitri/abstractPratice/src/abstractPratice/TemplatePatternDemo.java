package abstractPratice;

public class TemplatePatternDemo {
	public static void main(String[] args) {
		Game game1 = new Circket();
		game1.play();
		
		Game game2 = new Football();
		game2.play();
	}

}
