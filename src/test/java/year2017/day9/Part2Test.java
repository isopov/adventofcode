package year2017.day9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {

	@Test
	public void testRemoveGarbage() {
		assertEquals("{}", Part2.removeGarbage("{}"));
		assertEquals("{{{}}}", Part2.removeGarbage("{{{}}}"));
		assertEquals("{{},{}}", Part2.removeGarbage("{{},{}}"));
		assertEquals("{{{},{},{{}}}}", Part2.removeGarbage("{{{},{},{{}}}}"));

		assertEquals("{<>}", Part2.removeGarbage("{<{},{},{{}}>}"));
		assertEquals("{<>,<>,<>,<>}", Part2.removeGarbage("{<a>,<a>,<a>,<a>}"));
		assertEquals("{{<>},{<>},{<>},{<>}}", Part2.removeGarbage("{{<a>},{<a>},{<a>},{<a>}}"));
		assertEquals("{{<>}}", Part2.removeGarbage("{{<!>},{<!>},{<!>},{<a>}}"));

		assertEquals("{{<>},{<>},{<>},{<>}}", Part2.removeGarbage("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
	}

	@Test
	public void testRemoveScreened() {
		assertEquals("{}", Part2.removeScreened("{}"));
		assertEquals("{{{}}}", Part2.removeScreened("{{{}}}"));
		assertEquals("{{},{}}", Part2.removeScreened("{{},{}}"));
		assertEquals("{{{},{},{{}}}}", Part2.removeScreened("{{{},{},{{}}}}"));
		assertEquals("{<{},{},{{}}>}", Part2.removeScreened("{<{},{},{{}}>}"));
		assertEquals("{<a>,<a>,<a>,<a>}", Part2.removeScreened("{<a>,<a>,<a>,<a>}"));
		assertEquals("{{<a>},{<a>},{<a>},{<a>}}", Part2.removeScreened("{{<a>},{<a>},{<a>},{<a>}}"));

		assertEquals("{{<},{<},{<},{<a>}}", Part2.removeScreened("{{<!>},{<!>},{<!>},{<a>}}"));
		assertEquals("{{<>},{<>},{<>},{<>}}", Part2.removeScreened("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
	}


}
