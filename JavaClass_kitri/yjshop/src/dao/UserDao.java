package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.UserEntity;

public class UserDao {
	private static Connection conn = null;
	
	public UserDao() {}
	
	public UserEntity getUserFromId(String id) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.247:1521:xe", "coffee", "1234");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		List<UserEntity> matchUserList = sqlMatchId(id);
			if(matchUserList.size() == 1) {
				return matchUserList.get(0);
			}
			

		return null;
	}

	private List<UserEntity> sqlMatchId(String id) {
		String sql = "SELECT * FROM shopuser WHERE id=?";
		
		try {
			List<UserEntity> matchUserList = new ArrayList<>();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				matchUserList.add(new UserEntity(
								rs.getString("id"),
								rs.getString("pw"),
								rs.getString("name"),
								rs.getString("address")
								));
			return matchUserList;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int sqlInsertLoginId(String id) {
		
		//다른 ID 로그아웃
		System.out.println("INSERT SQL");
		String loginSql = "INSERT INTO loginlog(sn, id, status) "
				   + "VALUES (seqlogin.NEXTVAL, ?, 'Y')";
		String logoutSql = "UPDATE loginlog SET status = 'N' WHERE status = 'Y'";
		try {
			PreparedStatement pstmt = conn.prepareStatement(logoutSql);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

}
