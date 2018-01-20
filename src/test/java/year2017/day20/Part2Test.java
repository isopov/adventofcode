package year2017.day20;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Part2Test {

	@Test
	public void test() {
		assertEquals(1, Part2.noCollisions(Arrays.asList(
				"p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>",
				"p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>",
				"p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>",
				"p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>")));
	}
}
