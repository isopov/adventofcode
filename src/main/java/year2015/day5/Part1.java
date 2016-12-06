package year2015.day5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Part1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day5-input"))) {
			int result = 0;
			while (scanner.hasNext()) {
				if (isNice(scanner.next())) {
					result++;
				}
			}
			System.out.println(result);
		}
	}

	private static Set<Integer> VOWELS = new HashSet<>(
			Arrays.asList((int) 'a', (int) 'e', (int) 'i', (int) 'o', (int) 'u'));

	private static boolean isNice(String next) {
		// It does not contain the strings ab, cd, pq, or xy, even if they are
		// part of one of the other requirements
		if (next.contains("ab") || next.contains("cd") || next.contains("pq") || next.contains("xy")) {
			return false;
		}
		// It contains at least one letter that appears twice in a row, like xx,
		// abcdde (dd), or aabbccdd (aa, bb, cc, or dd)
		boolean twiceInARow = false;
		for (int i = 1; i < next.length(); i++) {
			if (next.charAt(i - 1) == next.charAt(i)) {
				twiceInARow = true;
				break;
			}
		}
		if (!twiceInARow) {
			return false;
		}

		// It contains at least three vowels (aeiou only), like aei, xazegov, or
		// aeiouaeiouaeiou

		return next.chars().filter(VOWELS::contains).count() >= 3;
	}
}
