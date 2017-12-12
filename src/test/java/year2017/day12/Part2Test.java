package year2017.day12;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class Part2Test {
	@Test
	public void testNumberOfGroups() {
		assertEquals(2,
				Part2.numberOfGroups(
						Stream.of(
								"0 <-> 2",
								"1 <-> 1",
								"2 <-> 0, 3, 4",
								"3 <-> 2, 4",
								"4 <-> 2, 3, 6",
								"5 <-> 6",
								"6 <-> 4, 5")));
	}
}
