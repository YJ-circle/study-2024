package abstractPratice;

public class Football extends Game{

	

	@Override
	public void startPlay() {
		System.out.println("Football startPlay");
		
	}

	@Override
	public void endPlay() {
		System.out.println("Football endPlay");		
	}


	@Override
	public void initialize() {
		System.out.println("Football init");
	}

}
