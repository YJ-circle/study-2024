package dao;

import java.io.PrintWriter;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

import entity.MemberInfoEntity;
import setting.DBInfo;

public class MemberDao {
	private final String DB_URL = DBInfo.MEMBER.getDBURL();
	private final String DB_USER = DBInfo.MEMBER.getUSER();
	private final String DB_PASS = DBInfo.MEMBER.getPASS();
	private static HashMap<String, ArrayList<MemberInfoEntity>> cache = new HashMap<>();
	private static HashMap<String, Instant> vaildTime = new HashMap<>();
	
	
	public ArrayList<MemberInfoEntity> getMember(){
		String query = "SELECT * FROM member";
		if(isVaildCahche(query)) {
			if(isVaildTime(query)) {
				System.out.println("Cache Return");
				return cache.get(query);	
			} else {System.out.println("Cache invaild. SQL Return");}
			
		} else {System.out.println("SQL Return");}
		ArrayList<MemberInfoEntity> memberList = executeGetQuery(query, null);
		return memberList;
	}

	public ArrayList<MemberInfoEntity> getMember(String id){
		String query = "SELECT * FROM member WHERE id = ?";
		if(isVaildCahche(query + id)) {
			if(isVaildTime(query + id)) {
				System.out.println("Cache Return");
				return cache.get(query + id);
			} else {System.out.println("Cache invaild. SQL Return");}
		}  else {System.out.println("SQL Return");}
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
			cache = new HashMap<>();
			vaildTime = new HashMap<>();
			System.out.println("init cache");
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
		String saveKey = query;
		try	{ 
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(query);
			if(id!=null) {
				stmt.setString(1, id);
				saveKey += id;
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
		cache.put(saveKey, memberList);
		vaildTime.put(saveKey, Instant.now().plusSeconds(3600));
		return memberList;
	}
	
	private boolean isVaildCahche(String query) {
		if(cache.size() > 0 ) {
			return cache.containsKey(query);
		} 
		return false;
	}
	
	private boolean isVaildTime(String query) {
		Instant now = Instant.now();
		return now.isBefore(vaildTime.get(query));
	}


	
}
