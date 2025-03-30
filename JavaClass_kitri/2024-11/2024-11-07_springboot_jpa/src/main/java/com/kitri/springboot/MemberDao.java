package com.kitri.springboot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends CrudRepository<MemberEntity, String>{
	List<MemberEntity> findByName(String name);
	List<MemberEntity> findByTestcolGreaterThanEqualAndActive(int testcol, String active);
	List<MemberEntity> findByNameAndAddress(String name, String address);
	List<MemberEntity> findByNameOrEmail(String name, String email);
	List<MemberEntity> findByTestcolLessThanEqualAndActiveOrAddress(int testcol, String active, String address);
	List<MemberEntity> findByTestcolGreaterThanEqualAndActiveAndEmailContaining(int testcol, String active, String email);
	List<MemberEntity> findByIdAndName(String id, String name);

}
