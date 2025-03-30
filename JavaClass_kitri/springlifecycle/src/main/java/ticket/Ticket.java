package ticket;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Ticket {
	private String id;
	@PostConstruct
	public void creatBean() {
		System.out.println("빈 생성");
	}
	
	@PreDestroy
	public void deleteBean() {
		System.out.println("빈 종료");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "티켓 id = " + id;
	}
}
