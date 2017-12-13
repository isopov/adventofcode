package year2017.day13;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Part1Test {
	@Test
	public void test() {
		int severity = Part1.severity(new String[] {
				"0: 3",
				"1: 2",
				"4: 4",
				"6: 4"
		});
		assertEquals(24, severity);
	}
}
