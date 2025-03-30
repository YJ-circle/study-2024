package springproperties;

/**
 * @author kitri03
 *
 */
public class MyDAO2 {
	private String url;
	private String username;
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MyDAO2 [url=" + url + ", username=" + username + ", password=" + password + "]";
	}


	
	
	
	
	
}
