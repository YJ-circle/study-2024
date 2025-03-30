package com.kitri.spring.board.dto;

public class PostDto implements Comparable<PostDto>{
	int postId;
	int boardId;
	String postTitle;
	String writerName;
	String writerId;
	String writeDate;
	
	public int getPostId() {
		return postId;
	}
	public PostDto setPostId(int postId) {
		this.postId = postId;
		return this;
	}
	public int getBoardId() {
		return boardId;
	}
	public PostDto setBoardId(int boardId) {
		this.boardId = boardId;
		return this;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public PostDto setPostTitle(String postTitle) {
		this.postTitle = postTitle;
		return this;
	}
	public String getWriterName() {
		return writerName;
	}
	public PostDto setWriterName(String writerName) {
		this.writerName = writerName;
		return this;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public PostDto setWriteDate(String writeDate) {
		this.writeDate = writeDate;
		return this;
	}
	public String getWriterId() {
		return writerId;
	}
	public PostDto setWriterId(String writerId) {
		this.writerId = writerId;
		return this;
	}
	@Override
	public int compareTo(PostDto o) {
		return this.getPostId() < o.getPostId() ? -1 : 
					(this.getBoardId() == o.getBoardId() ? 0 : 1);
	}
	

}
