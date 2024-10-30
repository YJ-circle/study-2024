package com.kitri.spring.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kitri.spring.board.dto.PostDto;
import com.kitri.spring.board.dto.PostViewDto;
import com.kitri.spring.board.service.IBoardService;

@Controller
public class BoardController {
	
	@Autowired
	private IBoardService boardService;
	
	/* 게시글 목록 보기 */
	@GetMapping("/board")
	public String postList(Model model,
						   @RequestParam(value = "sortType", 
						                 required = false, 
						                 defaultValue = "postId") String sortType) {
		//게시글 가져오기
		List<PostDto> postList = boardService.getPostList(sortType);
		if(!postList.isEmpty()) {
			model.addAttribute("postList", postList);
		}
		
		return "board";
	}
	
	/* 게시글 내용 보기 */
	@GetMapping("/board/view")
	public String postView(Model model,
  						  @SessionAttribute(
				              value = "login_id", 
							  required = false) Optional<String> userId,
				          @RequestParam("post_id") int postId) {
		
		//로그인 체크
		if(!isLogin(model, userId)) {return "login";}
		
		//게시글 내용 가져오기
		PostViewDto post = boardService.getPostDetailById(postId).get();
		
		model.addAttribute("post", post);
		return "board_view";
	}
	
	/* 게시글 작성 폼 출력 */
	@GetMapping("/board/write")
	public String showWriteForm(@SessionAttribute(
			                       value = "login_id", 
								   required = false) Optional<String> userId,
   								Model model) {
		
		//로그인 체크
		if(!isLogin(model, userId)) {return "login";}
		
		return "board_write";
	}
	
	/* 게시글 작성 수행 */
	@PostMapping("/board/write")
	public String writePost(@ModelAttribute PostViewDto postDto,
							 @SessionAttribute(value = "login_id", 
							                   required = false) Optional<String> userId,
							Model model) {
		if(!isLogin(model, userId)) {return "login";}
		postDto.setWriter(userId.get());
		boardService.writePost(model, postDto);
		return "board";
	}
	

	/* 게시글 수정 폼 */
	@GetMapping("/board/modify")
	public String showModifyForm(Model model,
								@SessionAttribute(value = "login_id", required = false)
								Optional<String> userId,
								@RequestParam("post_id") int postId
								) {
		
		if(!isLogin(model, userId)) {return "login";}
		
		boardService.showModifyForm(model, userId.get(), postId);
		
		return "board_write";
	}
	
	/* 게시글 수정 수행 */
	@PostMapping("/board/modify")
	public String modifyPost(Model model,
							@SessionAttribute(value = "login_id", required = false)
							Optional<String> userId,
							@RequestParam("post_id") int postId,
							@ModelAttribute PostViewDto postDto) {
		if(!isLogin(model, userId)) {return "login";}
		
		boardService.modifyPost(model, userId.get(), postId, postDto);
		return "board_view";
		
	}
	
	/* 게시글 삭제 */
	@RequestMapping("/board/delete")
	public String deletePost(@RequestParam("post_id") int postId,
            				@SessionAttribute(value = "login_id", required = false) 
		    				Optional<String> userId,
		    				Model model) {
		if(!isLogin(model, userId)) {return "login";}
		
		String result = boardService.deletePost(postId, userId.get());
		model.addAttribute("result", result);
		return "board";
		
	}
	
	
	/* 로그인 상태 체크 */
	private boolean isLogin(Model model, Optional<String> id) {
		if(id.isEmpty()) {
			model.addAttribute("errMsg", "로그인 후 이용 가능합니다.");
			return false;
		}
		return true;
	}
	
}
