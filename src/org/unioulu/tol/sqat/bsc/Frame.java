package org.unioulu.tol.sqat.bsc;

public class Frame {
	private static final int MAX_SCORE = 10;
	
	private int firstThrow;
	private int secondThrow;
	private int bonusThrow;
	private int bonusThrowSecond;
	
	private boolean isLastFrame;
	
	private int strikeExtraScore = 0;
	
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
		if (firstThrow + secondThrow > MAX_SCORE) {
			throw new IllegalArgumentException(
					String.format("Total sum of throws must be between 0 and 10 (was %s and %s)",
							firstThrow, secondThrow));		
		}
	}
	
	public int getStrikeExtra() {
		return strikeExtraScore;
	}
	
	public void setStrikeExtra(int extraScore) {
		this.strikeExtraScore = extraScore;
	}
	
	//the score of a single frame
	public int score(){
		if (isLastFrame() && isStrike()) {
			return firstThrow + secondThrow + bonusThrow + bonusThrowSecond;
		}
		
		if (isLastFrame() && isSpare()) {
			return firstThrow + secondThrow + bonusThrow;
		}
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
		if (isStrike()) {
			return false;
		}
		return firstThrow + secondThrow == 10;
	}
	
	public void setIsLastFrame(boolean isLastFrame) {
		this.isLastFrame = isLastFrame;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		return isLastFrame;
	}
	
	public int getSecondBonus() {
		return this.bonusThrowSecond;
	}
	
	public void setSecondBonus(int score) {
		this.bonusThrowSecond = score;
	}

	//bonus throws
	public int bonus(){
		return bonusThrow;
	}
	
	public void setBonusThrow(int score) {
		this.bonusThrow = score;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}


	public int getSecondThrow() {
		return secondThrow;
	}
}
