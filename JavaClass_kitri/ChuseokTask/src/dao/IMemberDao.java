package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Setting.Database;
import dao.Dao;
import entity.MemberEntity;

public interface IMemberDao extends Dao {
	MemberEntity login(String id, String password) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

}
