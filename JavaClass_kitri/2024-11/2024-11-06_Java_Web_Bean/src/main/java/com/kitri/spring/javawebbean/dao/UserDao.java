package com.kitri.spring.javawebbean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kitri.spring.javawebbean.dto.UserDto;
import com.kitri.spring.javawebbean.rowmapper.UserRowMapper;
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
		public List<UserDto> getUserList(){
			String sql = "select id, password, name FROM member";
			jdbcTemplate.queryForList(sql);
			return jdbcTemplate.query(sql, new UserRowMapper());
	}

}
