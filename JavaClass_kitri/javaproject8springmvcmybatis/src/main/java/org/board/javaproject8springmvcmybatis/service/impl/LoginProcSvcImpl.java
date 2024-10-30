package org.board.javaproject8springmvcmybatis.service.impl;

import org.board.javaproject8springmvcmybatis.dao.ILoginProcDao;
import org.board.javaproject8springmvcmybatis.dto.UserInfoDto;
import org.board.javaproject8springmvcmybatis.entity.UserInfoEntity;
import org.board.javaproject8springmvcmybatis.service.ILoginProcSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("loginsvc")
public class LoginProcSvcImpl implements ILoginProcSvc {
	@Autowired
	@Qualifier("logindao")
	ILoginProcDao loginProcDao;

	public UserInfoDto checkIdPwd(UserInfoDto userInfoDto) {
		return convertToDto(loginProcDao.checkIdPwd(userInfoDto));
	}

	private UserInfoDto convertToDto(UserInfoEntity userInfoEntity) {
		UserInfoDto dto = new UserInfoDto();
		dto.setId(userInfoEntity.getId());
		dto.setPwd(userInfoEntity.getPwd());
		dto.setName(userInfoEntity.getName());
		return dto;
	}
}