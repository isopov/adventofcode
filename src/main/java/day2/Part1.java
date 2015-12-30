package day2;

import java.util.Scanner;
import java.util.stream.Stream;

public class Part1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day2-input"))) {
			int result = 0;
			while (scanner.hasNext()) {
				result += getArea(scanner.next());
			}
			System.out.println(result);
		}
	}

	private static int getArea(String spec) {
		String[] split = spec.split("x");
		int[] sides = Stream.of(split).mapToInt(Integer::valueOf).toArray();

		int result = 2 * sides[0] * sides[1];
		result += 2 * sides[0] * sides[2];
		result += 2 * sides[1] * sides[2];

		result += Math.min(Math.min(sides[0] * sides[1], sides[0] * sides[2]), sides[1] * sides[2]);

		return result;

	}

}
