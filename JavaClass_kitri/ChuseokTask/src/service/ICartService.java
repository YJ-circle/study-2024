package service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ICartDto;

public interface ICartService {
	public boolean addCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException;
	public List<ICartDto> getCart(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException;
	
}
