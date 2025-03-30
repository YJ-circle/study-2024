package standardanno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Instructor {
	
	@Value("1")
	private int id = 22;
	
	@Value("홍길동")
	private String name="함예정";
	
	@Value("#{linkedlist}")
	private List<String> myList; 
	
	@Autowired
	private Profile profile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", myList=" + myList + ", profile=" + profile + "]";
	}

	
	
}
