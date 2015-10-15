package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
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

}
