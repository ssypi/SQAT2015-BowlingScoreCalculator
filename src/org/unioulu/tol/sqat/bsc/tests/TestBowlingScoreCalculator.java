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
		game.addFrame(new Frame(9,1));
		game.addFrame(new Frame(0,1));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(8,2));		
	}
	
	@Test
	public void frame_should_have_two_throws() {
		int first = 1;
		int second = 2;
		Frame frame = new Frame(first, second);
		
		assertEquals(first, frame.getFirstThrow());
		assertEquals(second, frame.getSecondThrow());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throw_should_not_be_over_10() {
		new Frame(11, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void throw_should_not_be_under_0() {
		new Frame(0, -1);
	}
	
	@Test
	public void frame_score_should_equal_to_sum_of_throws() {
		Frame frame = new Frame(2, 4);
		assertEquals(6, frame.score());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void frame_score_should_not_exceed_10_should_throw() {
		new Frame(2, 9);
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
	
	@Test
	public void frame_should_be_strike_if_first_throw_10() {
		Frame frame = new Frame(10, 0);
		assertTrue(frame.isStrike());
	}
	
	@Test
	public void frame_should_not_be_strike_if_second_throw_10() {
		Frame frame = new Frame(0, 10);
		assertFalse(frame.isStrike());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void strike_should_not_have_second_throw() {
		new Frame(10, 1);		
	}
	
	@Test
	public void strike_score_should_be_10_plus_next_frame() {
		List<Frame> frames = game.getFrames();
		frames.get(0).setThrows(0, 0);
		frames.get(1).setThrows(5, 4);		
		int score = game.score();
		
		frames.get(0).setThrows(10, 0);
		
		int expectedStrikeScore = score + 10 + 5 + 4;
		
		assertEquals(expectedStrikeScore, game.score());		
	}
	
	@Test
	public void frame_should_be_spare_when_all_pins_down_in_two_throws() {
		Frame frame = new Frame(4, 6);
		assertTrue(frame.isSpare());
	}
	
}
