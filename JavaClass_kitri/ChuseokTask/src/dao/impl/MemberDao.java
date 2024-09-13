package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Setting.Database;
import dao.Dao;
import dao.IMemberDao;
import entity.MemberEntity;

public class MemberDao implements IMemberDao {
	public MemberEntity login(String inputId, String inputPassword) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			db.setStatement("SELECT * FROM shopuser WHERE id = ?"); //  WHERE id = ?
			System.out.println("db 연결");
			db.sqlAddString(1, inputId);
			System.out.println("SQL 완성!");
			System.out.println();
			MemberEntity member = db.sqlSelectEntity(MemberEntity.class);
			return member;
		}
	}

}
