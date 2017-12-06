package year2017.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Part2 {
	public static void main(String[] args) {
		int[] input = getInput();

		int counter = 0;
		int index = 0;
		for (;;) {
			counter++;
			int steps = input[index];
			if (steps >= 3) {
				input[index]--;
			} else {
				input[index]++;
			}
			index += steps;
			if (index >= input.length) {
				System.out.println(counter);
				return;
			}
		}

	}

	private static int[] getInput() {
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input")))
				.lines()) {
			return lines.mapToInt(Integer::valueOf)
					.toArray();
		}
	}

}
