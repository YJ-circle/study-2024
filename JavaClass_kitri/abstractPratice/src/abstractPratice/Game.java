package abstractPratice;

public abstract class Game {
	abstract public void initialize();
	abstract public void startPlay();
	abstract public void endPlay();
	public void play() {
		initialize();
		startPlay();
		endPlay();
	}

}
