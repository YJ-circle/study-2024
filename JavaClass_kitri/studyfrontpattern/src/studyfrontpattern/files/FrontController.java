package studyfrontpattern.files;
public class FrontController {
	private static Dispatcher dispatcher = new Dispatcher();
	
	private boolean isAuthenticUser() {
		System.out.println("isAuthenticUser");
		System.out.println("일단 통과");
		return false;
	}
	
	private boolean trackRequest() {
		System.out.println("trackRequest");
		System.out.println("일단 통과");
		return false;
	}
	public void dispatchRequest(String req) {
		
		//잘못된 요청이면 true리턴
		if(trackRequest()) {
			return;
		}
		
		//권한이 없으면 true리턴
		if(isAuthenticUser()) {
			return;
		}
		
		
		dispatcher.dispatch(req);
		
	}
	
	

}
