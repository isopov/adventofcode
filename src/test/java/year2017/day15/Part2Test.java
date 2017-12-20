package year2017.day15;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part2Test {

	@Test
	public void testJudge() {
		assertEquals(309, Part2.judge(65, 8921, 5_000_000));
	}
	
	@Test
	public void testDivNext() {
		//A sample
		assertEquals(1352636452, Part2.divNext(65, 16807L, 4));
		assertEquals(1992081072, Part2.divNext(1352636452, 16807L, 4));
		assertEquals(530830436, Part2.divNext(1992081072, 16807L, 4));
		assertEquals(1980017072, Part2.divNext(530830436, 16807L, 4));
		assertEquals(740335192, Part2.divNext(1980017072, 16807L, 4));
		
		
		
		//B sample
		assertEquals(1233683848, Part2.divNext(8921, 48271L, 8));
		assertEquals(862516352, Part2.divNext(1233683848, 48271L, 8));
		assertEquals(1159784568, Part2.divNext(862516352, 48271L, 8));
		assertEquals(1616057672, Part2.divNext(1159784568, 48271L, 8));
		assertEquals(412269392, Part2.divNext(1616057672, 48271L, 8));
	}
}
