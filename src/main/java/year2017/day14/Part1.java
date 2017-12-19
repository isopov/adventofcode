package year2017.day14;

import year2017.day10.KnotHash;

public class Part1 {

	public static void main(String[] args) {
		System.out.println(usedSquares("nbysizxe"));
	}

	static int usedSquares(String input) {
		int result = 0;
		for (int i = 0; i < 128; i++) {
			int[] hash = KnotHash.knotHashInt(input + "-" + i);
			for (int part : hash) {
				result += Integer.bitCount(part);
			}
		}

		return result;
	}

}
