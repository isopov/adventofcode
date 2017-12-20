package year2017.day17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {
	@Test
	public void test() {
		assertEquals(2, Part2.after0(3, 2));
		assertEquals(5, Part2.after0(3, 6));
		assertEquals(5, Part2.after0(3, 7));
		assertEquals(5, Part2.after0(3, 8));
		assertEquals(9, Part2.after0(3, 9));

//		assertEquals(638, Part2.after0(3, 2017));

	}
}
