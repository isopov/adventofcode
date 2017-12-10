package year2017.day10;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void testReverse1() {
		int[] values = new int[] { 1, 2, 3, 4, 5 };
		Part1.reverse(0, 2, values);
		Assert.assertArrayEquals(new int[] { 2, 1, 3, 4, 5 }, values);
	}

	@Test
	public void testReverse2() {
		int[] values = new int[] { 1, 2, 3, 4, 5 };
		Part1.reverse(0, 3, values);
		Assert.assertArrayEquals(new int[] { 3, 2, 1, 4, 5 }, values);
	}

	@Test
	public void testReverse3() {
		int[] values = new int[] { 1, 2, 3, 4, 5 };
		Part1.reverse(4, 3, values);
		Assert.assertArrayEquals(new int[] { 1, 5, 3, 4, 2 }, values);
	}

	@Test
	public void testHash() {
		Part1.knotHash(5, new int[] { 3, 4, 1, 5 });
	}

}
