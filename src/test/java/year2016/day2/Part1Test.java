package year2016.day2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Part1Test {

	@Test
	public void test(){
		assertEquals("1985", Part1.code(Arrays.asList("ULL","RRDDD","LURDL","UUUUD")));
	}
}
