package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudentDto;
import entity.StudentInfoEntity;
import service.StudentSvcimpl;

@WebServlet("/addstudent")
public class StudentAdd extends HttpServlet{
	private final static String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe";
	private final static String USER = "test";
	private final static String PASS = "1234";


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/studentAdd.html");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String INSERT_SQL1 = "INSERT INTO student(stu_id, stu_major, stu_name, stu_phone)"
				+ " VALUES(?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		String result = "";
		boolean isVaildInput = true;
		int stu_id = 0;
		int stu_major = 0;
		try {
			stu_id = Integer.parseInt(req.getParameter("stu_id"));
		} catch (NumberFormatException e1) {
			result += "<br />학번이 숫자가 아닙니다.";
			isVaildInput = false;

		}
		
		try {
			stu_major = Integer.parseInt(req.getParameter("stu_major"));
		} catch (NumberFormatException e1) {
			result += "<br />전공 코드가 숫자가 아닙니다.";
			isVaildInput = false;
		}
		
		if (!isVaildInput) {
			System.out.println(result);
			String print = "ERROR: 추가 실패 (입력 값 오류)";
			print += result;
			req.setAttribute("result", print);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/addResult.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		try {
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			String stu_phone = req.getParameter("stu_phone");
			String stu_name = req.getParameter("stu_name");
			
			PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL1);

			pstmt.setInt(1, stu_id);
			pstmt.setInt(2, stu_major);
			pstmt.setString(3, stu_name);
			pstmt.setString(4, stu_phone);
			int cnt = pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			conn.close();
			String print = "입력 성공!"
					+ "추가 된 행 개수: " + cnt;
			
			StudentInfoEntity addstuEntity = new StudentInfoEntity(stu_id, stu_major, stu_name, stu_phone);
			ArrayList<StudentInfoEntity> addstudent = new ArrayList<>();
			addstudent.add(addstuEntity);
			req.setAttribute("list", addstudent);
			req.setAttribute("result", print);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/addResult.jsp");
			dispatcher.forward(req, resp);
			
		}
		
		catch (SQLException e) {
			String print = "ERROR: 추가 실패 (SQL오류)";
			req.setAttribute("result", print);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/addResult.jsp");
			dispatcher.forward(req, resp);
		}
	}

	
}
