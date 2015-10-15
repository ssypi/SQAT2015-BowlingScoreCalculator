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
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(10,8));
		game.addFrame(new Frame(0,1));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(10,10));		
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
		assertEquals(10, game.getFrames().size());		
	}
	
	@Test
	public void game_score_should_equal_to_sum_of_frame_scores() {
		int sum = 0;
		for (Frame frame : game.getFrames()) {
			sum += frame.score();
		}
		assertTrue(sum != 0);
		assertEquals(sum, game.score());
	}

}
