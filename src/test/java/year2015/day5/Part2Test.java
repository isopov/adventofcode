package year2015.day5;

import static year2015.day5.Part2.correctOverlaps;
import static year2015.day5.Part2.correctRepeats;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Part2Test {
	@Test
	public void testCorrectOverlaps() {
		assertFalse(correctOverlaps("aaa"));
		assertTrue(correctOverlaps("ababa"));
		assertTrue(correctOverlaps("aaaa"));
		assertTrue(correctOverlaps("aabaa"));
	}

	@Test
	public void testCorrectRepeats() {
		assertFalse(correctRepeats("aabbaa"));
		assertTrue(correctRepeats("ababbaa"));
	}
}
