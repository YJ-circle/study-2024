package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import Setting.Database;
import dao.Dao;
import entity.IEntity;
import entity.MemberEntity;
import error.login.LoginError;

public class MemberDao implements Dao {

	@Override
	public List<MemberEntity> getByIndex(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			db.setStatement("SELECT * FROM shopuser WHERE id = ?"); //  WHERE id = ?
			db.sqlAddString(1, id);
			List<MemberEntity> memberList = db.sqlSelectList(MemberEntity.class);
			if(memberList.size() != 1) {
				throw new LoginError("유효하지 않은 사용자입니다");
			}
			return memberList;
		}
	}

	@Override
	public List<MemberEntity> getByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberEntity> getByCustomCol(String columName, String targetName)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return null;
	}

}
