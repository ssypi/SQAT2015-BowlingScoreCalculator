package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	private BowlingGame game;
	
	@Before
	public void setupGame() {
		game = new BowlingGame();
		
	}
	
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
	
	@Test
	public void game_score_should_equal_to_sum_of_frame_scores() {
		List<Frame> frames = new ArrayList<>();
		int sum = 0;
		for (int i=0; i < 10; i++) {
			sum += i;
			sum += i+1;
			frames.add(new Frame(i, i+1));
		}
		BowlingGame game = new BowlingGame(frames);
		assertEquals(sum, game.score());
	}

}
