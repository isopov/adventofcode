package year2017.day11;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void testSteps1() {
		assertEquals(3, Part1.steps("ne,ne,ne"));
	}

	@Test
	public void testSteps2() {
		assertEquals(0, Part1.steps("ne,ne,sw,sw"));
	}

	@Test
	public void testSteps3() {
		assertEquals(2, Part1.steps("ne,ne,s,s"));
	}

	@Test
	public void testSteps4() {
		assertEquals(3, Part1.steps("se,sw,se,sw,sw"));
	}

}
