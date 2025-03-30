package com.kitri.spring.board.dao.impl;

import java.util.List;
import java.util.Optional;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kitri.spring.board.dao.IPostDao;
import com.kitri.spring.board.dto.PostViewDto;
import com.kitri.spring.board.entity.Post;
import com.kitri.spring.board.entity.PostDetail;

@Repository("postDao")
public class PostDaoImpl implements IPostDao{

    @Autowired
    @Qualifier("postSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;
    
	
	@Override
	public List<Post> getPostAll() {
		return sqlSessionTemplate.selectList("post.getPostAll");
	}

	@Override
	public Optional<Post> getPostById(int postId) {
		return Optional.ofNullable(
				   sqlSessionTemplate
				     .selectOne("post.getPostById", postId));
	}

	@Override
	public Optional<PostDetail> getPostDetailById(int postId) {
		return Optional.ofNullable(
				sqlSessionTemplate
				  .selectOne("post.getPostDetailById", postId));
				
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int writePost(PostViewDto newPost) {
		int result = 0;
		result += sqlSessionTemplate.insert("post.writePost", newPost);
		result += sqlSessionTemplate.insert("post.writePostDetail", newPost);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deletePost(int postId) {
		return sqlSessionTemplate.update("post.deletePost", postId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updatePost(PostViewDto updatePost) {
		int result = 0;
		result += sqlSessionTemplate.update("post.updatePost", updatePost);
		result += sqlSessionTemplate.update("post.updatePostDetail", updatePost);
		return result;
	}
	
}
