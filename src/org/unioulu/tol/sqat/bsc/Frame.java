package org.unioulu.tol.sqat.bsc;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame() {
		
	}
	
	public Frame(int firstThrow, int secondThrow){
		setThrows(firstThrow, secondThrow);
	}
	
	private boolean isValid(int throwScore) {
		return (throwScore >= 0 && throwScore <= 10);
	}
	
	
	public void setThrows(int first, int second) {
		this.firstThrow = first;
		this.secondThrow = second;
		
		if (!isValid(firstThrow) || !isValid(secondThrow)) {
			throw new IllegalArgumentException(
					String.format("Throws must be between 0 and 10 (was %s and %s)",
							firstThrow, secondThrow));	
		}		
		if (isStrike() && secondThrow > 0) {
			throw new IllegalArgumentException("Strike should only have one throw");
		}
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
	
	public int getFirstThrow() {
		return firstThrow;
	}


	public int getSecondThrow() {
		return secondThrow;
	}
}
