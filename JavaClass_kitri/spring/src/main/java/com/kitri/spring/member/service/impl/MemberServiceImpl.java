package com.kitri.spring.member.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.spring.member.dao.IMemberDao;
import com.kitri.spring.member.dto.LoginDto;
import com.kitri.spring.member.dto.MemberDto;
import com.kitri.spring.member.entity.Member;
import com.kitri.spring.member.service.IMemberService;


@Service("memberSerivce")
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	IMemberDao memberDao;

	@Override
	public Optional<MemberDto> login(String id, String password) {
		MemberDto memberDto = null;
		LoginDto dto = new LoginDto()
				       .setId(id)
				       .setPassword(password);
		
		Optional<Member> memberEntity = memberDao.login(dto);
		
		if(memberEntity.isPresent()) {
			Member entity = memberEntity.get();
			memberDto = new MemberDto()
					    .setId(entity.getId())
					    .setName(entity.getName())
					    .setAddress(entity.getAddress());
		}
		return Optional.ofNullable(memberDto);
	}
	

}
