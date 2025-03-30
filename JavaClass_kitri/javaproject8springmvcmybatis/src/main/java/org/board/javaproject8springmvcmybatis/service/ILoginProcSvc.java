package org.board.javaproject8springmvcmybatis.service;

import org.board.javaproject8springmvcmybatis.dto.UserInfoDto;

public interface ILoginProcSvc {

	UserInfoDto checkIdPwd(UserInfoDto userInfoDto);

}
