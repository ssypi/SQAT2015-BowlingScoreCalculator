package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	@Test
	public void frame_should_have_two_throws() {
		int first = 1;
		int second = 2;
		Frame frame = new Frame(first, second);
		
		assertEquals(first, frame.getFirstThrow());
		assertEquals(second, frame.getSecondThrow());	
	
	}
	
	@Test
	public void frame_score_should_equal_to_sum_of_throws() {
		Frame frame = new Frame(2, 4);
		assertEquals(6, frame.score());
	}
	
	@Test
	public void game_should_consist_of_10_frames() {
		BowlingGame game = new BowlingGame();
		assertEquals(10, game.getFrames().size());
		
	}

}
