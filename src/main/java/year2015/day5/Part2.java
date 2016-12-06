package year2015.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;

public class Part2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(Part2.class.getResourceAsStream("day5-input"))) {
			int result = 0;
			while (scanner.hasNext()) {
				if (isNice(scanner.next())) {
					result++;
				}
			}
			System.out.println(result);
		}
	}

	private static boolean isNice(String next) {
		return correctRepeats(next) && correctOverlaps(next);
	}

	// It contains at least one letter which repeats with exactly one letter
	// between them, like xyx, abcdefeghi (efe), or even aaa
	@VisibleForTesting
	static boolean correctRepeats(String next) {
		for (int i = 2; i < next.length(); i++) {
			if (next.charAt(i) == next.charAt(i - 2)) {
				return true;
			}
		}
		return false;
	}

	// It contains a pair of any two letters that appears at least twice in the
	// string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not
	// like aaa (aa, but it overlaps)
	@VisibleForTesting
	static boolean correctOverlaps(String next) {
		Map<Pair, Integer> firstPairs = new HashMap<>();
		for (int i = 1; i < next.length(); i++) {
			Pair pair = new Pair(next.charAt(i - 1), next.charAt(i));
			if (firstPairs.containsKey(pair)) {
				if (firstPairs.get(pair) != i - 1) {
					return true;
				}
			} else {
				firstPairs.put(pair, i);
			}
		}
		return false;
	}

	private static class Pair {
		private final char x, y;

		public Pair(char x, char y) {
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
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
