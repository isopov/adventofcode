package day24;

import static java.util.Arrays.asList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Part1 {

	private static final NavigableSet<Integer> INPUT = new TreeSet<>(asList(1, 2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37,
			41, 43, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113));

	private static final List<Integer> FIRST = new ArrayList<>();
	private static final List<Integer> SECOND = new ArrayList<>();
	private static final List<Integer> THIRD = new ArrayList<>();
	private static long result = Long.MAX_VALUE;
	private static int firstSize = Integer.MAX_VALUE;

	public static void main(String[] args) throws FileNotFoundException {
	}

	private static void iterate() {
		if (INPUT.isEmpty()) {
			int weight = sum(FIRST);
			if (weight == sum(SECOND) && weight == sum(THIRD)) {
				long qe = product(FIRST);
				if (firstSize > FIRST.size()) {
					result = qe;
				} else if (firstSize == FIRST.size()) {
					result = Math.min(qe, result);
				}
			}
		} else {

		}
	}

	private static int sum(List<Integer> list) {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}

		return result;
	}

	private static long product(List<Integer> list) {
		long result = 0L;
		for (int i = 0; i < list.size(); i++) {
			result *= list.get(i);
		}

		return result;
	}

}
