package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import entity.UserEntity;
import setting.Database;

public class UserDao {
	
	public UserDao() {}
	
	public UserEntity getUserFromId(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try(Database db = new Database();){
			db.setStatement("SELECT id, pw FROM shopuser WHERE id= ? ");
			db.sqlAddString(1, id);
			List<UserEntity> matchUserList = db.sqlSelectList(UserEntity.class);
			if(matchUserList.size() == 1) {
				return matchUserList.get(0);
			}
		}
		return null;
	}
}