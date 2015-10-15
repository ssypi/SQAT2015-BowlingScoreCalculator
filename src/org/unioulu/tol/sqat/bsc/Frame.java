package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame() {
		
	}
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		
		if (!isValid(firstThrow) || !isValid(secondThrow)) {
			throw new IllegalArgumentException("Throws must be between 0 and 10");	
		}		
	}
	
	private boolean isValid(int throwScore) {
		return (throwScore < 0 || throwScore > 10);
	}
	
	//the score of a single frame
	public int score(){
		return firstThrow + secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if (firstThrow == 10) {
			return true;
		} else {
			return false;
		}
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}
	
	public void setFirstThrow(int score) {
		this.firstThrow = score;
	}
	
	public void setSecondThrow(int score) {
		this.secondThrow = score;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}


	public int getSecondThrow() {
		return secondThrow;
	}
}
