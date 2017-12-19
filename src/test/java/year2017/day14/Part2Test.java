package year2017.day14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class Part2Test {

	@Test
	public void testCells() {
		Part2.Cell[][] cells = Part2.getCells("flqrgnkx");
		assertNotNull(cells[0][0]);
		assertNotNull(cells[0][1]);
		assertNull(cells[0][2]);
		assertNotNull(cells[0][3]);
		assertNull(cells[0][4]);
		assertNotNull(cells[0][5]);
		assertNull(cells[0][6]);
		assertNull(cells[0][7]);

		assertNull(cells[1][0]);
		assertNotNull(cells[1][1]);

		assertNull(cells[2][2]);

		assertNotNull(cells[7][5]);
		assertNotNull(cells[7][6]);
		assertNull(cells[7][7]);

	}

	@Test
	public void test() {
		assertEquals(1242, Part2.regions("flqrgnkx"));
	}

	@Test
	public void testPersonal() {
		assertEquals(1139, Part2.regions("nbysizxe"));
	}

}
