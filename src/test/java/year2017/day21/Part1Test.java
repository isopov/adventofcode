package year2017.day21;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Part1Test {

	
	@Test
	public void testPatternCreate() {
		assertEquals("../#.", new Part1.Pattern(false, false, true, false).toString());
	}
	
	@Test
	public void testPatternRotate() {
		assertEquals(new Part1.Pattern("../#."), new Part1.Pattern("../.#").rotate());
		assertEquals(new Part1.Pattern("#./.."), new Part1.Pattern("../#.").rotate());
		assertEquals(new Part1.Pattern(".#/.."), new Part1.Pattern("#./..").rotate());
		assertEquals(new Part1.Pattern("../.#"), new Part1.Pattern(".#/..").rotate());
	}
	
	
	@Test
	public void testPatternParse() {
		assertEquals("../.#", new Part1.Pattern("../.#").toString());
		assertEquals("#./.#", new Part1.Pattern("#./.#").toString());
		assertEquals(".#/#.", new Part1.Pattern(".#/#.").toString());
		
		assertEquals(".#./..#/###", new Part1.Pattern(".#./..#/###").toString());
		assertEquals(".#./..#/###", new Part1.Pattern(".#./..#/###").toString());
		assertEquals(".#./..#/###", new Part1.Pattern(".#./..#/###").toString());
		
		assertEquals("..../##.#/.###/.##.", new Part1.Pattern("..../##.#/.###/.##.").toString());
		
		
	}

	@Test
	public void test() {
		assertEquals(12,
				Part1.numberOfPixels(Arrays.asList("../.# => ##./#../...", ".#./..#/### => #..#/..../..../#..#"), 2));
	}

}
