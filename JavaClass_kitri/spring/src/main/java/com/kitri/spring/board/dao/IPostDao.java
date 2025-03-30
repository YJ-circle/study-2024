package com.kitri.spring.board.dao;

import java.util.List;
import java.util.Optional;

import com.kitri.spring.board.dto.PostViewDto;
import com.kitri.spring.board.entity.Post;
import com.kitri.spring.board.entity.PostDetail;

public interface IPostDao {
	/***
	 * 모든 게시글을 가져옵니다.
	 * @return 게시글 List
	 */
	
	List<Post> getPostAll();

	/***
	 * 게시글 id로 특정 게시글 요약 정보를 가져옵니다.
	 * @param id
	 * @return Post
	 */
	Optional<Post> getPostById(int id);

	
	/***
	 * 게시글 id로 특정 게시글의 상세 정보를 가져옵니다.
	 * @param postId
	 * @return PostDetail (게시글 내용 포함)
	 */
	Optional<PostDetail> getPostDetailById(int postId);

	/***
	 * 새로운 게시글을 작성합니다.
	 * @param newPost 새롭게 작성할 게시글 객체
	 * @return 삽입 된 행의 개수
	 */
	int writePost(PostViewDto newPost);

	/***
	 * 존재하는 게시글을 삭제합니다.
	 * 실제 작동은 Post 테이블의 active 칼럼을 'N'으로 업데이트합니다.
	 * 
	 * @param postId
	 * @return 업데이트 된 행의 개수
	 */
	int deletePost(int postId);

	/***
	 * 존재하는 게시글을 수정합니다.
	 * @param updatePost 수정하려는 게시글 객체
	 * @return 업데이트 된 행의 개수
	 */
	int updatePost(PostViewDto updatePost);
}
