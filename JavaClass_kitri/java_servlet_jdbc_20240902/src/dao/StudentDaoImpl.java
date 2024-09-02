package dao;

import java.sql.*;
import java.util.ArrayList;

import dto.StudentDto;
import entity.StudentInfoEntity;

public class StudentDaoImpl implements StudentDao{
	static final String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe"; 
	static final String USER = "test"; 
	static final String PASS = "1234"; 
	static final String QUERY = "SELECT * FROM student"; 
	
	@Override
	public ArrayList<StudentInfoEntity> getStudentInfo() {

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<StudentInfoEntity> studentList = new ArrayList<StudentInfoEntity>();
		// Open a connection 
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(QUERY);) 
		
			{ 
			// Extract data from result set 
				while (rs.next()) { 
				  StudentInfoEntity stu = new StudentInfoEntity();
				  stu.setStu_id(rs.getInt("stu_id"));
				  stu.setStu_major(rs.getInt("stu_major"));
				  stu.setStu_name(rs.getString("stu_name"));
				  stu.setStu_phone(rs.getString("stu_phone"));
				  studentList.add(stu);
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
