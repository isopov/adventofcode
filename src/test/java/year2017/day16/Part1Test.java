package year2017.day16;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void testDance() {
		assertEquals("baedc", Part1.dance(5, "s1,x3/4,pe/b"));
	}

	@Test
	public void testRotate() {
		char[] input = new char[] { 'a', 'b', 'c', 'd', 'e' };
		Part1.rotate(input, 3);
		Assert.assertArrayEquals(new char[] { 'c', 'd', 'e', 'a', 'b' }, input);
	}

	@Test
	public void testPrograms() {
		Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'e' }, Part1.programs(5));
	}
}
