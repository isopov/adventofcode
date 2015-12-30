package day2;

import java.util.Scanner;
import java.util.stream.Stream;

public class Part2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(Part2.class.getResourceAsStream("day2-input"))) {
			int result = 0;
			while (scanner.hasNext()) {
				result += getRibbon(scanner.next());
			}
			System.out.println(result);
		}
	}

	private static int getRibbon(String spec) {
		String[] split = spec.split("x");
		int[] sides = Stream.of(split).mapToInt(Integer::valueOf).toArray();

		int result = Math.min(2 * sides[0] + 2 * sides[1], 2 * sides[0] + 2 * sides[2]);
		result = Math.min(result, 2 * sides[1] + 2 * sides[2]);

		result += sides[0] * sides[1] * sides[2];

		return result;

	}

}
