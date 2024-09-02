package dao;

import java.util.ArrayList;
import java.util.List;

import dto.StudentDto;
import java.sql.*; 

public class StudentDao {
	static final String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe"; 
	static final String USER = "test"; 
	static final String PASS = "1234"; 
	static final String QUERY = "SELECT * FROM student"; 
	
	
	public List<StudentDto> getStudentInfo(){

		
		List<StudentDto> studentList = new ArrayList<StudentDto>();

		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(QUERY);) 
		
			{ 
			// Extract data from result set 
				while (rs.next()) { 
				  StudentDto dto = new StudentDto();
				  dto.setStu_id(rs.getInt("stu_id"));
				  dto.setStu_name(rs.getString("stu_name"));
				  studentList.add(dto);
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) { 
		 	  e.printStackTrace(); 
			}
	
		return studentList;
	}
		
		
}
