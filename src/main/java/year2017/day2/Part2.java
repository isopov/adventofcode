package year2017.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Part2 {

	public static void main(String... args) {
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input")))
				.lines()) {
			int result = lines
					.map(s -> s.split("\t"))
					.mapToInt(Part2::dif)
					.sum();
			System.out.println(result);
		}
	}

	private static int dif(String[] line) {
		int[] intLine = Stream.of(line)
				.mapToInt(Integer::valueOf)
				.distinct()
				.sorted()
				.toArray();

		for (int i = 0; i < intLine.length; i++) {
			for (int j = i + 1; j < intLine.length; j++) {
				if(intLine[j] % intLine[i] == 0) {
					return intLine[j] / intLine[i];
				}
			}

		}
		return 0;
	}

}
