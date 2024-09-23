package common;

public class DatabaseError extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DatabaseError(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
