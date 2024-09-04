package service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.MemberDao;
import dto.MemberInfoDto;
import entity.MemberInfoEntity;

public class MemberSvc {
	public ArrayList<MemberInfoDto> getMember(){
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberInfoEntity> memberList = memberDao.getMember();
		return daoToDto(memberList);
	}
	
	public ArrayList<MemberInfoDto> getMember(String id){
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberInfoEntity> memberList = memberDao.getMember(id);
		return daoToDto(memberList);
	}
	
	public ArrayList<MemberInfoDto> addMileSvc(String id, int mileCnt){
		MemberDao memberDao = new MemberDao();
		
		if(memberDao.isMemberId(id)) {
			ArrayList<MemberInfoEntity> mileAddInfo = memberDao.addMile(id, mileCnt);
			ArrayList<MemberInfoDto> memberList = daoToDto(mileAddInfo);
			return memberList;
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
