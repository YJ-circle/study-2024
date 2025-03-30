package org.board.javaproject8springmvcmybatis.service;

import java.util.List;

import org.board.javaproject8springmvcmybatis.dto.BoardDto;

public interface IBoardProcSvc {
	public List<BoardDto> getPostList();
	public BoardDto getPostDetail(String seq);
}
