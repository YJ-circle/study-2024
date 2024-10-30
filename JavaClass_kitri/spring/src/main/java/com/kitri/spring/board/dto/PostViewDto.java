package com.kitri.spring.board.dto;

public class PostViewDto {
	private int postId;
	private String title;
	private String contents;
	private String writeDate;
	private String writer;
	public String getTitle() {
		return title;
	}
	public PostViewDto setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContents() {
		return contents;
	}
	public PostViewDto setContents(String contents) {
		this.contents = contents;
		return this;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public PostViewDto setWriteDate(String writeDate) {
		this.writeDate = writeDate;
		return this;
	}
	public String getWriter() {
		return writer;
	}
	public PostViewDto setWriter(String writer) {
		this.writer = writer;
		return this;
	}
	public int getPostId() {
		return postId;
	}
	public PostViewDto setPostId(int postId) {
		this.postId = postId;
		return this;
	}
	@Override
	public String toString() {
		return "PostViewDto [postId=" + postId + ", title=" + title + ", contents=" + contents + ", writeDate="
				+ writeDate + ", writer=" + writer + "]";
	}
	
	

}
