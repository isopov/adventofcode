package year2017.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Part1 {

	public static void main(String... args) {
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input")))
				.lines()) {
			int result = lines
					.map(s -> s.split("\t"))
					.mapToInt(Part1::dif)
					.sum();
			System.out.println(result);
		}
	}

	private static int dif(String[] line) {

		return Stream.of(line)
				.mapToInt(Integer::valueOf)
				.max().getAsInt()
				-
				Stream.of(line)
						.mapToInt(Integer::valueOf)
						.min().getAsInt();
	}

}
