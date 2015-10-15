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
		// calculate normal scores
		for (Frame frame : frames) {
			score += frame.score();
		}
		
		// add strikes
		for (int i=0; i < frames.size(); i++) {
			Frame frame = frames.get(i);
			if (frame.isStrike()) {
				if (frames.size() >= i+1) {
					Frame nextFrame = frames.get(i+1);
					score += nextFrame.score();
				}
			}
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
