package year2016.day2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Part2Test {

	@Test
	public void test() {
		assertEquals("5DB3", Part2.code(Arrays.asList("ULL", "RRDDD", "LURDL", "UUUUD")));
	}
}
