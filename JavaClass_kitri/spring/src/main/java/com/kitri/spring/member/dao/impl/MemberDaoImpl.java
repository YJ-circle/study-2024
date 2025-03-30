package com.kitri.spring.member.dao.impl;

import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kitri.spring.member.dao.IMemberDao;
import com.kitri.spring.member.dto.LoginDto;
import com.kitri.spring.member.entity.Member;

@Repository("memberDao")
public class MemberDaoImpl implements IMemberDao{
	
    @Autowired
    @Qualifier("memberSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;
    
    @Override
    public Optional<Member> login(LoginDto dto) {
        Member member = sqlSessionTemplate.selectOne("member.login", dto);
        return Optional.ofNullable(member);
    }

}
