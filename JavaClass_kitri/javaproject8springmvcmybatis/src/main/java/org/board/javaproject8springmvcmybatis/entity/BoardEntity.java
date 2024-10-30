package org.board.javaproject8springmvcmybatis.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class BoardEntity {
	private int seq;
	private String title;
	private String contents;
	private String id;

	public BoardEntity() {
	}

	public BoardEntity(int seq, String title, String contents, String id) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
