package com.kitri.spring.member.service;

import java.util.Optional;

import com.kitri.spring.member.dto.MemberDto;

public interface IMemberService {
	Optional<MemberDto> login(String id, String password);
}
