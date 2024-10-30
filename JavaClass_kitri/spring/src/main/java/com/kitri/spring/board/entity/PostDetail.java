package com.kitri.spring.board.entity;

public class PostDetail {
	private int postId;
	private String contents;
	public int getPostId() {
		return postId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

}
