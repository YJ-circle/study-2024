package setting;

public enum DBInfo {
	MEMBER("jdbc:oracle:thin:@192.168.10.247:1521:xe", "coffee", "1234");
	String DBURL; 
	String USER; 
	String PASS;
	
	private DBInfo(String DBURL, String USER, String PASS) {
		this.DBURL = DBURL;
		this.USER = USER;
		this.PASS = PASS;
	}

	public String getDBURL() {
		return DBURL;
	}

	public String getUSER() {
		return USER;
	}


	public String getPASS() {
		return PASS;
	}


}
