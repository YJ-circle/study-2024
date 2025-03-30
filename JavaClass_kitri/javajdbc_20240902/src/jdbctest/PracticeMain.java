package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PracticeMain {
	private final static String DB_URL = "jdbc:oracle:thin:@192.168.10.247:1521:xe";
	private final static String USER = "test";
	private final static String PASS = "1234";

	public static void main(String[] args) {
		String INSERT01 = "INSERT INTO student(stu_id, stu_major, stu_name, stu_phone)"
				+ " VALUES('202402004','1','홍길동','010-1234-1234')";
		String INSERT02 = "INSERT INTO student(stu_id, stu_major, stu_name, stu_phone)"
				+ " VALUES(?,?,?,?)";
		
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		try {
			
			System.out.println("정적 SQL");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(INSERT01);
			System.out.println("영향을 받는 행 수: " + cnt);
			
			System.out.println("동적 SQL");
			System.out.print("학번을 입력하세요: ");
			int stuId = sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.print("전공코드를 입력하세요 (1 or 2): ");
			int stuMajor = sc.nextInt();
			sc.nextLine();
			System.out.println();
			System.out.print("이름을 입력하세요: ");
			String stuName = sc.nextLine();
			System.out.println();
			System.out.print("휴대폰 번호 (010-1234-1234): ");
			String stuPhone = sc.nextLine();
			PreparedStatement pstmt = conn.prepareStatement(INSERT02);
			pstmt.setInt(1, stuId);
			pstmt.setInt(2, stuMajor);
			pstmt.setString(3, stuName);
			pstmt.setString(4, stuPhone);
			cnt = pstmt.executeUpdate();
			System.out.println("영향을 받는 행 수: " + cnt);
			conn.commit();
						
			PreparedStatement pstmt2 = conn.prepareStatement(INSERT02);
			System.out.println("동적 배치 처리");
			while(true) {
				System.out.print("학번을 입력하세요: (-1 입력시 종료 후 저장)");
				stuId = sc.nextInt();
				sc.nextLine();
				
				if(stuId == -1) break;
				
				System.out.println();
				System.out.print("전공코드를 입력하세요 (1 or 2): ");
				stuMajor = sc.nextInt();
				sc.nextLine();
				System.out.println();
				System.out.print("이름을 입력하세요: ");
				stuName = sc.nextLine();
				System.out.println();
				System.out.print("휴대폰 번호 (010-1234-1234): ");
				stuPhone = sc.nextLine();
				pstmt2.setInt(1, stuId);
				pstmt2.setInt(2, stuMajor);
				pstmt2.setString(3, stuName);
				pstmt2.setString(4, stuPhone);
				pstmt2.addBatch();
			}
			pstmt2.executeBatch();
			conn.commit();
			stmt.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
