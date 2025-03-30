package error;

public class AccessViolation extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	public AccessViolation(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
