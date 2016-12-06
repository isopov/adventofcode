package year2015.day7;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import year2015.day7.Part1.Element;

public class Part1Test {

	private HashMap<String, Element> elements;

	@Before

	public void setup() {
		elements = new HashMap<>();
		// 123 -> x
		// 456 -> y
		// x AND y -> d
		// x OR y -> e
		// x LSHIFT 2 -> f
		// y RSHIFT 2 -> g
		// NOT x -> h
		// NOT y -> i
		elements.put("x", new Element("123"));
		elements.put("y", new Element("456"));
		elements.put("d", new Element("x AND y"));
		elements.put("e", new Element("x OR y"));
		elements.put("f", new Element("x LSHIFT 2"));
		elements.put("g", new Element("y RSHIFT 2"));
		elements.put("h", new Element("NOT x"));
		elements.put("i", new Element("NOT y"));
	}

	@Test
	public void testX() {
		assertEquals(123, Part1.get(elements, "x"));
	}

	@Test
	public void testY() {
		assertEquals(456, Part1.get(elements, "y"));
	}

	@Test
	public void testI() {
		assertEquals(65079, Part1.get(elements, "i"));
	}

	@Test
	public void testH() {
		assertEquals(65412, Part1.get(elements, "h"));
	}

	@Test
	public void testD() {
		assertEquals(72, Part1.get(elements, "d"));
	}

	@Test
	public void testE() {
		assertEquals(507, Part1.get(elements, "e"));
	}

	@Test
	public void testF() {
		assertEquals(492, Part1.get(elements, "f"));
	}

	@Test
	public void testG() {
		assertEquals(114, Part1.get(elements, "g"));
	}

}
