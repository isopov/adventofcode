package year2016.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {
	@Test
	public void test() {
		assertEquals(5, Part1.distance("R2, L3"));
		assertEquals(2, Part1.distance("R2, R2, R2"));
		assertEquals(12, Part1.distance("R5, L5, R5, R3"));
	}

}
