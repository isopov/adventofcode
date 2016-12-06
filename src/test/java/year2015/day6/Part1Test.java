package year2015.day6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {

	@Test
	public void test1() {
		Part1 part1 = new Part1();
		part1.execute("turn on 0,0 through 999,999");
		assertEquals(1000000, part1.countOn());
	}
}
