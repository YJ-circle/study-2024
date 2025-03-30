package com.kitri.spring.javawebbean.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.kitri.spring.javawebbean.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
		userDto.setId(rs.getString("id"));
		userDto.setPwd(rs.getString("password"));
		userDto.setName(rs.getString("name"));
		
		return userDto;
	}

}
