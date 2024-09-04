package dao;

import java.sql.*;
import java.util.ArrayList;
import entity.MemberInfoEntity;
import setting.DBInfo;

public class MemberDao {
	private static final String DB_URL = DBInfo.MEMBER.getDBURL();
	private static final String DB_USER = DBInfo.MEMBER.getUSER();
	private static final String DB_PASS = DBInfo.MEMBER.getPASS();
	
	
	public ArrayList<MemberInfoEntity> getMember(){
		String query = "SELECT * FROM member";
		ArrayList<MemberInfoEntity> memberList = executeGetQuery(query, null);
		return memberList;
	}

	public ArrayList<MemberInfoEntity> getMember(String id){
		String query = "SELECT * FROM member WHERE id = ?";
		ArrayList<MemberInfoEntity> memberList = executeGetQuery(query, id);
		return memberList;
	}
	
	public boolean isMemberId(String id) {
		ArrayList<MemberInfoEntity> memberList = getMember(id);
		return memberList.size() != 0;
	}
	
	public ArrayList<MemberInfoEntity> addMile(String id, int mileCnt) {
		String query = "UPDATE member SET mile = mile + ? WHERE id = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int cnt = 0;
		try	{ 
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, mileCnt);
			stmt.setString(2, id);
			cnt += stmt.executeUpdate();
			conn.commit();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) { 
			 	  e.printStackTrace(); 
		}
		if (cnt > 0) {
			return getMember(id);
		}
		return null;
	}
	
	private ArrayList<MemberInfoEntity> executeGetQuery(String query, String id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<MemberInfoEntity> memberList = new ArrayList<MemberInfoEntity>();
		
		try	{ 
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(query);
			if(id!=null) {
				stmt.setString(1, id);
			}
			ResultSet rs = stmt.executeQuery();
				while (rs.next()) { 
					MemberInfoEntity memEntity = new MemberInfoEntity();
					memEntity.setId(rs.getString("id"));
					memEntity.setName(rs.getString("name"));
					memEntity.setCoupon(rs.getInt("coupon"));
					memEntity.setMile(rs.getInt("mile"));
					memEntity.setActive(rs.getString("active"));
					memberList.add(memEntity);
				}
				conn.commit();
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) { 
		 	  e.printStackTrace(); 
			}
		return memberList;
	}
	
}
