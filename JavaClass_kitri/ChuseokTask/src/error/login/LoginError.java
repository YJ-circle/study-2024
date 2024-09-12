package error.login;

public class LoginError extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public LoginError(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	

}
