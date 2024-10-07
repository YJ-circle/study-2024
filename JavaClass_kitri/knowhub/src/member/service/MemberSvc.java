package member.service;

import member.entity.MemberEntity;

public interface MemberSvc {
	public boolean login(String id, String password);
	public boolean logout();
	public MemberEntity getMemberById();
}
