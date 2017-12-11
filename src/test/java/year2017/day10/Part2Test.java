package year2017.day10;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {

	@Test
	public void testLengths() {
		assertArrayEquals(new int[] { 49, 44, 50, 44, 51, 17, 31, 73, 47, 23 }, Part2.lengths("1,2,3"));
	}

	@Test
	public void testXor() {
		assertEquals(64, Part2.xor(0, 16, new int[] { 65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22 }));
	}

	@Test
	public void testHash1() {
		assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Part2.knotHash(""));
	}

	@Test
	public void testHash2() {
		assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Part2.knotHash("AoC 2017"));
	}

	@Test
	public void testHash3() {
		assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Part2.knotHash("1,2,3"));
	}

	@Test
	public void testHash4() {
		assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Part2.knotHash("1,2,4"));
	}
}
