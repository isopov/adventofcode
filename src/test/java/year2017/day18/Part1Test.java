package year2017.day18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {

	@Test
	public void test() {
		String[] program = {
				"set a 1",
				"add a 2",
				"mul a a",
				"mod a 5",
				"snd a",
				"set a 0",
				"rcv a",
				"jgz a -1",
				"set a 1",
				"jgz a -2"
		};

		assertEquals(4, Part1.lastSound(program));
	}
}
