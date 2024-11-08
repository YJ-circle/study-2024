package com.kitri.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity{
	
	@Id
	@Column(name="BOARD_ID")
	int id;
	
	@Column(name="BOARD_NAME")
	String name;

}
