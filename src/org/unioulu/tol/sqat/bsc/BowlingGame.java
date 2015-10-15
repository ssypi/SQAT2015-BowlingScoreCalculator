package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	
	public BowlingGame(){
	}
	
	public BowlingGame(List<Frame> frames) {
		this.frames = frames;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int score = 0;
		for (Frame frame : frames) {
			score += frame.score();
		}
		return score;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
}
