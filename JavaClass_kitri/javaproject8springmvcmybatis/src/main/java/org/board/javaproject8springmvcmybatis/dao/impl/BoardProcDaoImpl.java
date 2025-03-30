package org.board.javaproject8springmvcmybatis.dao.impl;

import java.util.List;

import org.board.javaproject8springmvcmybatis.dao.IBoardProcDao;
import org.board.javaproject8springmvcmybatis.entity.BoardEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boarddao")
public class BoardProcDaoImpl implements IBoardProcDao{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardEntity> getPostList() {
		return sqlSessionTemplate.selectList("boardEntity.getPostList");
	}
	
	@Override
	public BoardEntity getPostDetail(String seq) {
		return sqlSessionTemplate.selectOne("boardEntity.getPostDetail", seq);
	}
}