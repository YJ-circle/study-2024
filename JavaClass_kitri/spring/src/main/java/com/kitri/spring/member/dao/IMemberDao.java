package com.kitri.spring.member.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kitri.spring.member.dto.LoginDto;
import com.kitri.spring.member.entity.Member;

public interface IMemberDao {
	Optional<Member> login(LoginDto dto);
}
