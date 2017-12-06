package year2017.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Part1 {
	public static void main(String[] args) {
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input")))
				.lines()) {
			long count = lines.map(s -> s.split(" "))
					.filter(Part1::uniq)
					.count();

			System.out.println(count);
		}
	}

	private static boolean uniq(String[] phrases) {
		Set<String> set = new HashSet<>();
		for (String phrase : phrases) {
			if (!set.add(phrase)) {
				return false;
			}
		}
		return true;
	}

}
