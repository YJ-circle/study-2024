package com.kitri.spring.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

import com.kitri.spring.board.dto.PostDto;
import com.kitri.spring.board.dto.PostViewDto;

public interface IBoardService {
	/***
	 * Dao를 호출하여 전체 게시글 목록을 가져오고,
	 * sortType으로 정렬합니다.
	 * 
	 * 현재 sortType의 기본 설정은 post_id기준입니다.
	 * 
	 * TODO: sortType의 Comparator를 구현하여 선택 가능하도록 개선
	 * 
	 * @param sortType
	 * @return 게시글 리스트
	 */
	List<PostDto> getPostList(String sortType);
	
	/**
	 * 게시글 ID를 사용하여 해당 게시글의 상세 정보를 조회합니다.
	 * 
	 * 게시글이 존재하지 않을 경우, NoSuchElementException을 발생시킵니다. 
	 * 
	 * TODO: 게시글이 존재하지 않을 경우 예외 대신 다른 방식으로 처리하도록 개선해야 합니다.
	 * 
	 * @param postId 게시글 ID
	 * @return 게시글 상세 정보를 담고 있는 Optional<PostViewDto> 객체
	 */
	Optional<PostViewDto> getPostDetailById(int postId);
	
	/**
	 * 게시글을 작성합니다.
	 * 
	 * 작성 결과에 따라 모델에 성공 또는 실패 메시지를 추가합니다.
	 * 
	 * @param model 결과 메시지를 추가할 모델
	 * @param postDto 작성할 게시글 정보를 담고 있는 PostViewDto 객체
	 */
	void writePost(Model model, PostViewDto postDto);
	
	/**
	 * 게시글을 삭제합니다.
	 * 
	 * 게시글이 존재하고, 요청한 사용자가 작성자인 경우 삭제를 수행합니다.
	 * 삭제 결과에 따라 성공 또는 실패 메시지를 반환합니다.
	 * 
	 * @param postId 삭제할 게시글 ID
	 * @param userId 요청한 사용자 ID
	 * @return 삭제 결과 메시지
	 */
	String deletePost(int postId, String userId);
	
	/**
	 * 수정 폼을 보여주기 위해 게시글 정보를 모델에 추가합니다.
	 * 
	 * 사용자가 해당 게시글의 작성자인 경우에만 접근이 허용됩니다.
	 * 
	 * @param model 모델 객체
	 * @param userId 요청한 사용자 ID
	 * @param postId 조회할 게시글 ID
	 */
	void showModifyForm(Model model, String userId, int postId);

	/**
	 * 게시글을 수정합니다.
	 * 
	 * 요청한 사용자가 작성자인 경우에만 수정이 허용됩니다.
	 * 수정 결과에 따라 모델에 성공 메시지를 추가합니다.
	 * 
	 * @param model 결과 메시지를 추가할 모델
	 * @param userId 요청한 사용자 ID
	 * @param postId 수정할 게시글 ID
	 * @param updatePost 수정할 게시글 정보를 담고 있는 PostViewDto 객체
	 */
	void modifyPost(Model model, String userId, int postId, PostViewDto updatePost);
}
