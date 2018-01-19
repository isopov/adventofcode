package year2017.day20;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Part1Test {

	@Test
	public void test() {
		assertEquals(0, Part1.minDistanceToZero(Arrays.asList(
				"p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>",
				"p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>")));
	}

	@Test
	public void testReverse() {
		assertEquals(1, Part1.minDistanceToZero(Arrays.asList(
				"p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>",
				"p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>")));
	}

}
