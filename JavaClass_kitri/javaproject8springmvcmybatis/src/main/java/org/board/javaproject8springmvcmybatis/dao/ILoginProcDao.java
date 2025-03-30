package org.board.javaproject8springmvcmybatis.dao;

import org.board.javaproject8springmvcmybatis.dto.UserInfoDto;
import org.board.javaproject8springmvcmybatis.entity.UserInfoEntity;

public interface ILoginProcDao {
	public UserInfoEntity checkIdPwd(UserInfoDto userInfoDto);
}
