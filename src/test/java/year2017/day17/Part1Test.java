package year2017.day17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {
	@Test
	public void test() {
		assertEquals(1, Part1.after(3, 2));
		assertEquals(5, Part1.after(3, 9));
		
		
		assertEquals(638, Part1.after(3, 2017));
		
	}
}
