package org.board.javaproject8springmvcmybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.board.javaproject8springmvcmybatis.dao.IBoardProcDao;
import org.board.javaproject8springmvcmybatis.dto.BoardDto;
import org.board.javaproject8springmvcmybatis.entity.BoardEntity;
import org.board.javaproject8springmvcmybatis.service.IBoardProcSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("boardsvc")
public class BoardProcSvcImpl implements IBoardProcSvc {

	@Autowired
	@Qualifier("boarddao")
	IBoardProcDao boardProcDao;

	@Override
	public List<BoardDto> getPostList() {
		return convertToDtoList(boardProcDao.getPostList());
	}

	@Override
	public BoardDto getPostDetail(String seq) {
		return convertToDto(boardProcDao.getPostDetail(seq));
	}

	private BoardDto convertToDto(BoardEntity boardEntity) {
		BoardDto dto = new BoardDto();
		dto.setSeq(boardEntity.getSeq());
		dto.setTitle(boardEntity.getTitle());
		dto.setContents(boardEntity.getContents());
		dto.setId(boardEntity.getId());
		return dto;
	}

	private List<BoardDto> convertToDtoList(List<BoardEntity> boardEntityList) {

		List<BoardDto> boardDtoList = new ArrayList<>();
		for (BoardEntity boardEntity : boardEntityList) {
			BoardDto dto = new BoardDto();
			dto.setSeq(boardEntity.getSeq());
			dto.setTitle(boardEntity.getTitle());
			dto.setContents(null);
			dto.setId(boardEntity.getId());
			boardDtoList.add(dto);
		}
		return boardDtoList;
	}

}
