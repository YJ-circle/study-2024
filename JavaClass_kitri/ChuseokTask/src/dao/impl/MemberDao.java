package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import commonFunc.Database;
import dao.IMemberDao;
import entity.MemberEntity;
import error.LoginError;

public class MemberDao implements IMemberDao {


	public MemberEntity getMemberInfoById(String id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		try(Database db = new Database();){
			db.setStatement("SELECT * FROM shopuser WHERE id = ?"); //  WHERE id = ?
			db.sqlAddString(1, id);
			List<MemberEntity> memberList = db.sqlSelectList(MemberEntity.class);
			if(memberList.size() != 1) {
				throw new LoginError("유효하지 않은 사용자입니다");
			}
			return memberList.get(0);
		}
	}





}
