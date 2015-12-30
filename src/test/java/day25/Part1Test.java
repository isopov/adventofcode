package day25;

import static day25.Part1.getCode;
import static day25.Part1.getIndex;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Part1Test {

	// | 1 2 3 4 5 6
	// ---+---------+---------+---------+---------+---------+---------+
	// 1 | 20151125 18749137 17289845 30943339 10071777 33511524
	// 2 | 31916031 21629792 16929656 7726640 15514188 4041754
	// 3 | 16080970 8057251 1601130 7981243 11661866 16474243
	// 4 | 24592653 32451966 21345942 9380097 10600672 31527494
	// 5 | 77061 17552253 28094349 6899651 9250759 31663883
	// 6 | 33071741 6796745 25397450 24659492 1534922 27995004

	@Test
	public void testCode() {
		assertEquals(20151125L, getCode(1, 1));

		assertEquals(27995004L, getCode(6, 6));
	}

	// | 1 2 3 4 5 6
	// ---+---+---+---+---+---+---+
	// 1 | 1 3 6 10 15 21
	// 2 | 2 5 9 14 20
	// 3 | 4 8 13 19
	// 4 | 7 12 18
	// 5 | 11 17
	// 6 | 16

	@Test
	public void testIndex() {
		assertEquals(1, getIndex(1, 1));
		assertEquals(2, getIndex(2, 1));
		assertEquals(3, getIndex(1, 2));

		assertEquals(18, getIndex(4, 3));
	}
}
