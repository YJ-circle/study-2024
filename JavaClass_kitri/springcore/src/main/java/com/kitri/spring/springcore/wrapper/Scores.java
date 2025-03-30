package com.kitri.spring.springcore.wrapper;

public class Scores {
	private double maths;
	private double physics;
	private double chemistry;
	
	

	public void setMaths(double maths) {
		this.maths = maths;
	}



	public void setPhysics(double physics) {
		this.physics = physics;
	}



	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}



	@Override
	public String toString() {
		return "Scores [maths=" + maths + ", physics=" + physics + ", chemistry=" + chemistry + "]";
	}
	
	
}
