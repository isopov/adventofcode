package year2017.day3;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void testDist1() {
		assertEquals(0, Part1.dist(1));
	}

	@Test
	public void testDist12() {
		assertEquals(3, Part1.dist(12));
	}

	@Test
	public void testDist23() {
		assertEquals(2, Part1.dist(23));
	}

	@Test
	public void testDist1024() {
		assertEquals(31, Part1.dist(1024));
	}

	@Test
	public void testCoords1() {
		Assert.assertArrayEquals(new int[] { 0, 0 }, Part1.coords(1));
	}

	@Test
	public void testCoords2() {
		Assert.assertArrayEquals(new int[] { 1, 0 }, Part1.coords(2));
	}

	@Test
	public void testCoords3() {
		Assert.assertArrayEquals(new int[] { 1, 1 }, Part1.coords(3));
	}

	@Test
	public void testCoords4() {
		Assert.assertArrayEquals(new int[] { 0, 1 }, Part1.coords(4));
	}

	@Test
	public void testCoords5() {
		Assert.assertArrayEquals(new int[] { -1, 1 }, Part1.coords(5));
	}

	@Test
	public void testCoords6() {
		Assert.assertArrayEquals(new int[] { -1, 0 }, Part1.coords(6));
	}

	@Test
	public void testCoords7() {
		Assert.assertArrayEquals(new int[] { -1, -1 }, Part1.coords(7));
	}

	@Test
	public void testCoords8() {
		Assert.assertArrayEquals(new int[] { 0, -1 }, Part1.coords(8));
	}

	@Test
	public void testCoords9() {
		Assert.assertArrayEquals(new int[] { 1, -1 }, Part1.coords(9));
	}

	@Test
	public void testCoords12() {
		Assert.assertArrayEquals(new int[] { 2, 1 }, Part1.coords(12));
	}
}
