package org.board.javaproject8springmvcmybatis.dao;

import java.util.List;

import org.board.javaproject8springmvcmybatis.entity.BoardEntity;

public interface IBoardProcDao {
	public List<BoardEntity> getPostList();
	public BoardEntity getPostDetail(String seq);
}
