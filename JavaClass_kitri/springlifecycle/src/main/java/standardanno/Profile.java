package standardanno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
@Component("pro")
public class Profile {
	// String title, String company, List<String> subjectList
	@Value("프로필")
	String title = "title";
	
	@Value("좋은 회사")
	String company = "good company";
	
	@Value("#{arraylist}")
	List<String> subjectList;

	@Override
	public String toString() {
		return "Profile [title=" + title + ", company=" + company + ", subjectList=" + subjectList + "]";
	}
	
	
}
