package year2017.day18;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;

import org.junit.Test;

import year2017.day18.Part2.Program;

public class Part2Test {

	@Test
	public void testMove() {
		String[] program = { "snd 1", "rcv a", "jgz a -2" };
		ArrayDeque<Long> rec = new ArrayDeque<>(asList(2L, -1L));
		ArrayDeque<Long> send = new ArrayDeque<>();
		Program actor = new Part2.Program(1, program, rec, send);
		actor.move();

		assertEquals(1, actor.registers.size());
		assertEquals(-1L, actor.registers.get('a'));
		assertEquals(3, actor.index);

		assertEquals(2, send.size());
		assertEquals(Long.valueOf(1L), send.peekFirst());
		assertEquals(Long.valueOf(1L), send.peekLast());

		assertTrue(rec.isEmpty());

		assertEquals(2, actor.sendCounter);
	}

	@Test
	public void testCounter() {
		String[] program = { "snd 5", "rcv a", "snd 1", "add a -1", "jgz a -2" };
		assertEquals(6, Part2.firstCounter(program));
	}
	
	@Test
	public void test1() {
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

		assertEquals(1, Part2.firstCounter(program));
	}
	
	
	@Test
	public void test() {
		String[] program = {
				"snd 1",
				"snd 2",
				"snd p",
				"rcv a",
				"rcv b",
				"rcv c",
				"rcv d"
		};

		assertEquals(3, Part2.firstCounter(program));
	}
}
