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
		
		oracleDriverLoad();		
		oracleConnect();
		List<UserEntity> matchUserList = sqlMatchId(id);
			if(matchUserList == null) { return null; }
			if(matchUserList.size() == 1) {
				return matchUserList.get(0);
			}
			return null;
	}





	private List<UserEntity> sqlMatchId(String id) {
		oracleDriverLoad();		
		oracleConnect();
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
			rs.close();
			pstmt.close();
			return matchUserList;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int sqlInsertLoginId(String id) {
		oracleDriverLoad();		
		oracleConnect();
		String loginSql = "INSERT INTO loginlog(sn, id, status) "
				   + "VALUES (seqlogin.NEXTVAL, ?, 'Y')";
		try {
			//다른 ID 로그아웃
			logout(null);
			PreparedStatement pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}
	
	public int logout(String id) {
		oracleDriverLoad();		
		oracleConnect();
		String logoutSql = "UPDATE loginlog SET status = 'N' WHERE status = 'Y'";

		try {
			PreparedStatement pstmt = conn.prepareStatement(logoutSql);
			if(id != null) {
				logoutSql += " AND id = ? ";
				pstmt = conn.prepareStatement(logoutSql);
				pstmt.setString(1, id);
			}
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}
	
	public UserEntity isLoginCheck() {
		oracleDriverLoad();
		oracleConnect();
		
		try {
			String sql = "SELECT * FROM loginlog WHERE status = 'Y'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				return sqlMatchId(rs.getString("id")).get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void oracleDriverLoad() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void oracleConnect() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.247:1521:xe", "coffee", "1234");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
