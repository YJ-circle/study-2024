package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import dto.StudentDto;
import entity.StudentInfoEntity;

public class StudentDaoImpl implements StudentDao, DBInfo{

	@Override
	public ArrayList<StudentInfoEntity> getStudentInfo() {

		String QUERY = "SELECT * FROM student"; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<StudentInfoEntity> studentList = new ArrayList<StudentInfoEntity>();
		// Open a connection 
		try(Connection conn = DriverManager.getConnection(DBInfo.DB_URL, DBInfo.USER, DBInfo.PASS); 
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
	
	@Override
	public StudentInfoEntity addStudent(int stu_id, int stu_major, String stu_name, String stu_phone) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conn = null;
			conn = DriverManager.getConnection(DBInfo.DB_URL, DBInfo.USER, DBInfo.PASS); 
			conn.setAutoCommit(false);
			String INSERT_SQL1 = "INSERT INTO student(stu_id, stu_major, stu_name, stu_phone)"
					+ " VALUES(?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL1);
	
			pstmt.setInt(1, stu_id);
			pstmt.setInt(2, stu_major);
			pstmt.setString(3, stu_name);
			pstmt.setString(4, stu_phone);
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			conn.close();			
			StudentInfoEntity addstuEntity = new StudentInfoEntity(stu_id, stu_major, stu_name, stu_phone);
			return addstuEntity;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	

}
