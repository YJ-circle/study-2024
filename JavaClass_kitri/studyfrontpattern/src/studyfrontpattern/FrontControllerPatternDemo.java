package studyfrontpattern;

import studyfrontpattern.files.FrontController;

public class FrontControllerPatternDemo {
	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		
		System.out.println("\n=====home 접속=====\n");
		frontController.dispatchRequest("home");
		System.out.println("\n=====학생페이지 접속=====\n");
		frontController.dispatchRequest("student");
	}

}
