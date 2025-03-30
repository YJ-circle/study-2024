package com.spring.springorm.mybatis.mybatispractice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("memberDao")
public class MemberDaoImpl {
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 회원 ID로 회원 정보를 조회하는 메서드
    public Member findMemberById(String id) {
        return sqlSessionTemplate.selectOne("member.findMemberId", id);
    }
    
    public List<Member> findMemberAll() {
    	return sqlSessionTemplate.selectList("member.findMemberAll");
    }

    public int addMember(Member member) {
    	return (int) sqlSessionTemplate.insert("member.addMember", 
    									 member
    									 );
    }
    
    public List<Member> findCustom(SelectCond cond) {
    	return sqlSessionTemplate.selectList("member.findCustom", cond);
    }
}