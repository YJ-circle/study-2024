package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import entity.IEntity;
import entity.MemberEntity;
import entity.ProductEntity;

public interface Dao {
	<T extends IEntity> List<T> getByIndex(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	<T extends IEntity> List<T> getByAll() throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	<T extends IEntity> List<T> getByCustomCol(String columName, String targetName) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	List<ProductEntity> getByColSetString(String columName, String targetName)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException;
	List<ProductEntity> getByColSetInt(String columName, int targetInt)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException;
}
