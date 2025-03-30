package dao;

public interface DBInfo {
	static final String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe"; 
	static final String USER = "test"; 
	static final String PASS = "1234"; 
	static final String QUERY = "SELECT * FROM student"; 
}
