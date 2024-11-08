package com.kitri.springboot;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="POST")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	@Id
	@Column(name="POST_ID")
	int id;
	
	@Column(name="POST_TITLE")
	String title;
	
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private BoardEntity board;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WRITER_ID")
	private MemberEntity wrtier;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="WRITE_DATE")
	private LocalDate writeDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="EDIT_DATE")
	private LocalDate editDate;
	
	
	@Column(name="ACTIVE")
	private String active;
}
