package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.database.Database;
import entity.UserEntity;

public class UserDao {
	
	public UserDao() {}
	
	public UserEntity getUserFromId(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database(UserEntity.class);){
			db.setStatement("SELECT id, pw FROM shopuser WHERE id= ? ");
			db.sqlAddString(1, id);
			List<UserEntity> matchUserList = new ArrayList<>();
			matchUserList = db.sqlSelectList();
			if(matchUserList.size() == 1) {
				return matchUserList.get(0);
			}
		}
		return null;
	}
}