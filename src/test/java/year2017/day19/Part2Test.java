package year2017.day19;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {

	@Test
	public void test() {
		assertEquals(38, Part1.walk(Part1Test.testMap(), 'F').steps);
	}
}
