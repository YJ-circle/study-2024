package com.kitri.spring.springcore.wrapper;

public class Student {
	private String name;
	private Scores scores;
	public void setScores(Scores scores) {
		this.scores = scores;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "학생 이름: " + name + "/ 점수: " + scores.toString();
	}
}
