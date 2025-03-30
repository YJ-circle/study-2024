package service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.MemberDao;
import dto.MemberInfoDto;
import entity.MemberInfoEntity;

public class MemberSvc {
	public ArrayList<MemberInfoDto> getMember(){
		return daoToDto(new MemberDao().getMember());
	}
	
	public ArrayList<MemberInfoDto> getMember(String id){
		return daoToDto(new MemberDao().getMember(id));
	}
	
	public ArrayList<MemberInfoDto> addMile(String id, int mileCnt){
		MemberDao memberDao = new MemberDao();
		if(memberDao.isMemberId(id)) {
			return daoToDto(memberDao.addMile(id, mileCnt));
		} 
		return null;
	}


	private ArrayList<MemberInfoDto> daoToDto(ArrayList<MemberInfoEntity> memberList) {
		MemberInfoDto memberInfo = null;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		ArrayList<MemberInfoDto> memberDto = new ArrayList<MemberInfoDto>();
		for(MemberInfoEntity member : memberList) {
			memberInfo = new MemberInfoDto();
			memberInfo.setId(member.getId());
			memberInfo.setName(member.getName());
			memberInfo.setMile(member.getMile());
			memberInfo.setCoupon(member.getCoupon());
			memberDto.add(memberInfo);
		}
		return memberDto;
	}

}
