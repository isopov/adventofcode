package year2015.day6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {

	@Test
	public void test1() {
		Part2 part = new Part2();
		part.execute("turn on 0,0 through 999,999");
		assertEquals(1000000, part.countOn());
	}

	@Test
	public void test2() {
		Part2 part = new Part2();
		part.execute("toggle 0,0 through 999,999");
		assertEquals(2000000, part.countOn());
	}

	@Test
	public void test3() {
		Part2 part = new Part2();
		part.execute("turn on 0,0 through 0,0");
		assertEquals(1, part.countOn());
	}

	@Test
	public void test4() {
		Part2 part = new Part2();
		part.execute("toggle 0,0 through 999,999");
		part.execute("turn off 0,0 through 999,999");
		assertEquals(1000000, part.countOn());
	}

	@Test
	public void test5() {
		Part2 part = new Part2();
		part.execute("turn off 0,0 through 999,999");
		assertEquals(0, part.countOn());
	}

}
