package org.board.javaproject8springmvcmybatis.dao.impl;

import org.board.javaproject8springmvcmybatis.dao.ILoginProcDao;
import org.board.javaproject8springmvcmybatis.dto.UserInfoDto;
import org.board.javaproject8springmvcmybatis.entity.UserInfoEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logindao")
public class LoginProcDaoImpl implements ILoginProcDao{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public UserInfoEntity checkIdPwd(UserInfoDto userInfoDto) {
		return sqlSessionTemplate.selectOne("userEntity.checkIdPwd", userInfoDto);
	}
}
