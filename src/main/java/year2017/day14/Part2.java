package year2017.day14;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;

import com.google.common.base.Preconditions;

import year2017.day10.KnotHash;

public class Part2 {

	public static void main(String[] args) {
		System.out.println(regions("nbysizxe"));
	}

	static int regions(String input) {
		Cell[][] cells = getCells(input);

		mergeRegions(cells);

		Set<Set<Cell>> regions = Collections.newSetFromMap(new IdentityHashMap<>());
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (cells[i][j] != null) {
					regions.add(cells[i][j].region);
				}
			}
		}

		return regions.size();
	}

	static Cell[][] getCells(String input) {
		Cell[][] cells = new Cell[128][];
		for (int i = 0; i < 128; i++) {
			cells[i] = new Cell[128];
			int[] hash = KnotHash.knotHashInt(input + "-" + i);
			String bitStr = toBitString(hash);
			for (int j = 0; j < bitStr.length(); j++) {
				if (bitStr.charAt(j) == '1') {
					cells[i][j] = new Cell(i, j);
				}
			}
		}
		return cells;
	}

	static void mergeRegions(Cell[][] cells) {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (cells[i][j] != null) {
					if (i > 0) {
						if (j > 0) {
							if (cells[i - 1][j - 1] != null) {
								merge(cells[i][j], cells[i - 1][j - 1]);
							}
						}
						if (j < 127) {
							if (cells[i - 1][j + 1] != null) {
								merge(cells[i][j], cells[i - 1][j + 1]);
							}
						}
					}
					if (i < 127) {
						if (j > 0) {
							if (cells[i + 1][j - 1] != null) {
								merge(cells[i][j], cells[i + 1][j - 1]);
							}
						}
						if (j < 127) {
							if (cells[i + 1][j + 1] != null) {
								merge(cells[i][j], cells[i + 1][j + 1]);
							}
						}
					}
				}
			}
		}
	}

	static void merge(Cell foo, Cell bar) {
		if (foo.region != bar.region) {
			int fooSize = foo.region.size();
			int barSize = bar.region.size();
			foo.region.addAll(bar.region);
			if (foo.region.size() != fooSize + barSize) {
				throw new IllegalStateException();
			}
			for (Cell cell : bar.region) {
				cell.region = foo.region;
			}
		}
	}

	static String toBitString(int[] hash) {
		StringBuilder result = new StringBuilder(128);

		for (int part : hash) {
			result.append(String.format("%8s", Integer.toBinaryString(part)).replace(" ", "0"));
		}
		Preconditions.checkState(result.length() == 128);
		return result.toString();
	}

	static class Cell {
		final int x, y;
		Set<Cell> region = new HashSet<>(Arrays.asList(this));

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}
