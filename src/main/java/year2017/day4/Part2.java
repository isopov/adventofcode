package year2017.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Part2 {
	public static void main(String[] args) {
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input")))
				.lines()) {
			long count = lines.map(s -> s.split(" "))
					.filter(Part2::uniq)
					.count();

			System.out.println(count);
		}
	}

	private static boolean uniq(String[] phrases) {

		Set<Multiset<Character>> set = new HashSet<>();
		for (String phrase : phrases) {
			Multiset<Character> letters = HashMultiset.create();
			for (int i = 0; i < phrase.length(); i++) {
				letters.add(phrase.charAt(i));
			}
			if (!set.add(letters)) {
				return false;
			}
		}
		return true;
	}

}
