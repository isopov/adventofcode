package year2017.day19;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {

	static char[][] testMap() {
		String[] input = {
				"     |          ",
				"     |  +--+    ",
				"     A  |  C    ",
				" F---|----E|--+ ",
				"     |  |  |  D ",
				"     +B-+  +--+ "
		};

		char[][] map = new char[input.length][];
		for (int i = 0; i < input.length; i++) {
			map[i] = new char[input[i].length()];
			for (int j = 0; j < input[i].length(); j++) {
				map[i][j] = input[i].charAt(j);
			}
		}

		return map;
	}

	@Test
	public void test() {
		assertEquals("ABCDEF", Part1.walk(testMap(), 'F').seen.toString());
	}
}
