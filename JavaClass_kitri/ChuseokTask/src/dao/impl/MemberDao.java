package dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import Setting.Database;
import dao.Dao;
import entity.MemberEntity;

public class MemberDao implements Dao {
	public void login(String id, String password) throws Exception {
		List<MemberEntity> memberList = null;
		PreparedStatement pstmt = null;
		try(Database db = new Database();){
			pstmt = db.setStatement("SELECT * FROM shopuser");
			for(MemberEntity m : memberList) {
				System.out.println(m.getName());
			}
		}
		finally {
			pstmt.close();
		}
		
		if(idInvalid(memberList)) {
			
		}
		
	}

	private boolean idInvalid(List<MemberEntity> memberList) {
		return memberList == null;
	}

}
