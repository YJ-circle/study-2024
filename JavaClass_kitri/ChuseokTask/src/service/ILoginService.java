package service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Dto;
import dto.IMemberDto;
import dto.impl.MemberDto;

public interface ILoginService {
	IMemberDto login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException;
}
