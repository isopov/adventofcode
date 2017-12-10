package year2017.day9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {

	@Test
	public void testRemoveGarbage() {
		assertEquals("{}", Part1.removeGarbage("{}"));
		assertEquals("{{{}}}", Part1.removeGarbage("{{{}}}"));
		assertEquals("{{},{}}", Part1.removeGarbage("{{},{}}"));
		assertEquals("{{{},{},{{}}}}", Part1.removeGarbage("{{{},{},{{}}}}"));

		assertEquals("{}", Part1.removeGarbage("{<{},{},{{}}>}"));
		assertEquals("{,,,}", Part1.removeGarbage("{<a>,<a>,<a>,<a>}"));
		assertEquals("{{},{},{},{}}", Part1.removeGarbage("{{<a>},{<a>},{<a>},{<a>}}"));
		assertEquals("{{}}", Part1.removeGarbage("{{<!>},{<!>},{<!>},{<a>}}"));

		assertEquals("{{},{},{},{}}", Part1.removeGarbage("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
	}

	@Test
	public void testRemoveScreened() {
		assertEquals("{}", Part1.removeScreened("{}"));
		assertEquals("{{{}}}", Part1.removeScreened("{{{}}}"));
		assertEquals("{{},{}}", Part1.removeScreened("{{},{}}"));
		assertEquals("{{{},{},{{}}}}", Part1.removeScreened("{{{},{},{{}}}}"));
		assertEquals("{<{},{},{{}}>}", Part1.removeScreened("{<{},{},{{}}>}"));
		assertEquals("{<a>,<a>,<a>,<a>}", Part1.removeScreened("{<a>,<a>,<a>,<a>}"));
		assertEquals("{{<a>},{<a>},{<a>},{<a>}}", Part1.removeScreened("{{<a>},{<a>},{<a>},{<a>}}"));

		assertEquals("{{<},{<},{<},{<a>}}", Part1.removeScreened("{{<!>},{<!>},{<!>},{<a>}}"));
		assertEquals("{{<>},{<>},{<>},{<>}}", Part1.removeScreened("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
	}

	@Test
	public void testScore() {
		assertEquals(1, Part1.score("{}"));
		assertEquals(6, Part1.score("{{{}}}"));
		assertEquals(5, Part1.score("{{},{}}"));
		assertEquals(16, Part1.score("{{{},{},{{}}}}"));
		assertEquals(1, Part1.score("{<a>,<a>,<a>,<a>}"));
		assertEquals(9, Part1.score("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
		assertEquals(9, Part1.score("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
		assertEquals(3, Part1.score("{{<a!>},{<a!>},{<a!>},{<ab>}}"));

	}

}
