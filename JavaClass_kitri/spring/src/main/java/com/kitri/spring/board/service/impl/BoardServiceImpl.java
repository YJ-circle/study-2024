package com.kitri.spring.board.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kitri.spring.board.dao.IPostDao;
import com.kitri.spring.board.dto.PostDto;
import com.kitri.spring.board.dto.PostViewDto;
import com.kitri.spring.board.entity.Post;
import com.kitri.spring.board.entity.PostDetail;
import com.kitri.spring.board.service.IBoardService;

@Controller("boardService")
public class BoardServiceImpl implements IBoardService{
	
	@Autowired
	IPostDao postDao;

	@Override
	public List<PostDto> getPostList(String SortType) {
		List<Post> postList = postDao.getPostAll();
		List<PostDto> postDto = new ArrayList<PostDto>();
		if(postList != null && !postList.isEmpty()) {
			for (Post post : postList) {
				postDto.add(new PostDto()
						    .setPostId(post.getPostId())
						    .setBoardId(post.getBoardId())
						    .setPostTitle(post.getPostTitle())
						    .setWriteDate(post.getWriteDate())
						    .setWriterName(post.getWriterName())
						    .setWriterId(post.getWriterId())
						    );
			}
		}
		
		postDto.sort(null);
		return postDto;
	}

	@Override
	public Optional<PostViewDto> getPostDetailById(int postId) {
		PostViewDto postDto = null;
		Optional<Post> post = postDao.getPostById(postId);
		Post postSummary = post.get();
		
		if(post.isPresent()) {
			//TODO Post가 없으면 예외가 아닌 방식으로 수정해야함.
			PostDetail postDetail = postDao.getPostDetailById(postId)
					                       .orElseThrow(() -> new NoSuchElementException("게시글 상세정보 찾기 실패"));
			postDto = new PostViewDto()
					           .setTitle(postSummary.getPostTitle())
					           .setWriteDate(postSummary.getWriteDate())
					           .setWriter(postSummary.getWriterName())
					           .setPostId(postSummary.getPostId())
					           .setContents(postDetail.getContents());
			
		}
		return Optional.ofNullable(postDto);
	}

	
	@Override
	public void writePost(Model model, PostViewDto postDto) {
		int insertColum = postDao.writePost(postDto);
		if(insertColum == 2) {
			model.addAttribute("result", "게시글 작성 성공");
		} else {
			model.addAttribute("result", "게시글 작성 실패");
		}
	}
	
	@Override
	public String deletePost(int postId, String userId) {
		Optional<Post> post = postDao.getPostById(postId);
		Optional<String> errorMessage = isAuthorized(post, userId);
		if(errorMessage.isPresent()) {
			return errorMessage.get();
		}
		
		int updateColum = postDao.deletePost(postId);
		
		if(updateColum == 1) {
			return "삭제 성공";
		}
		
		return "알 수 없는 오류로 삭제 실패";
		
	}
	
	@Override
	public void showModifyForm(Model model, String userId, int postId) {
		Optional<Post> post = postDao.getPostById(postId);
		Optional<String> errorMessage = isAuthorized(post, userId);
		if(errorMessage.isPresent()) {
			model.addAttribute("errMsg", errorMessage.get());
			return;
		}
		
		model.addAttribute("title", post.get().getPostTitle());
		model.addAttribute("contents", postDao.getPostDetailById(postId)
										.get().getContents()
										.replace("<br/>", "\n"));
		
	}
	

	@Override
	public void modifyPost(Model model, String userId, int postId, PostViewDto updatePost) {
		Optional<Post> post = postDao.getPostById(postId);
		Optional<String> errorMessage = isAuthorized(post, userId);
		if(errorMessage.isPresent()) {
			model.addAttribute("errMsg", errorMessage);
		}
		
		updatePost.setWriter(userId);
		updatePost.setPostId(postId);
		updatePost.setContents(updatePost.getContents()
				                         .replace("\n", "<br/>")); 
		int insertColum = postDao.updatePost(updatePost);
		if(insertColum == 2) {
			model.addAttribute("result", "게시글 수정 성공");
			model.addAttribute("post_id", postId);
		}
	}
	
	/**
	 * 게시글에 대한 접근 권한을 확인합니다.
	 * 
	 * 게시글이 존재하지 않거나, 작성자가 아닌 경우 에러 메시지를 반환합니다.
	 * 
	 * @param post 게시글 정보
	 * @param userId 요청한 사용자 ID
	 * @return 접근 권한 검사 결과 메시지를 담고 있는 Optional
	 */
	private Optional<String> isAuthorized(Optional<Post> post, String userId) {
		String result = null;

		if(post.isEmpty()) {
			result = "게시글이 없습니다";
		}
		
		if(!post.get().getWriterId().equals(userId)) {
			result = "작성자만 접근 가능합니다";
		}
		
		return Optional.ofNullable(result);
		
	}

}
