package year2017.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {

	@Test
	public void test0() {
		assertEquals(6, Part2.sum("1212"));
	}
	@Test
	public void test1() {
		assertEquals(0, Part2.sum("1221"));
	}
	@Test
	public void test2() {
		assertEquals(4, Part2.sum("123425"));
	}
	@Test
	public void test3() {
		assertEquals(12, Part2.sum("123123"));
	}
	@Test
	public void test4() {
		assertEquals(4, Part2.sum("12131415"));
	}
	
	
}
