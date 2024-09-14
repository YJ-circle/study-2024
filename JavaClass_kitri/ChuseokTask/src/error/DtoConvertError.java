package error;

import entity.IEntity;

public class DtoConvertError extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	private Object entity;
	public DtoConvertError(String message, IEntity entity) {
		super();
		this.message = message;
		this.entity = entity;
	}
	public String getMessage() {
		return "오류 메시지: " + message + "\n 객체: " +  entity.toString();
	}
}
