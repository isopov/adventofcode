package year2017.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {

	@Test
	public void test0() {
		assertEquals(3, Part1.sum("1122"));
	}
	@Test
	public void test1() {
		assertEquals(4, Part1.sum("1111"));
	}
	@Test
	public void test2() {
		assertEquals(0, Part1.sum("1234"));
	}
	@Test
	public void test3() {
		assertEquals(9, Part1.sum("91212129"));
	}
	
}
