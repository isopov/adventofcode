package day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;

public class Part1 {

	public static void main(String[] args) {
		Map<String, Element> elements = new HashMap<>();

		try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day7-input"))) {
			while (scanner.hasNextLine()) {
				String[] next = scanner.nextLine().split(" -> ");
				elements.put(next[1], new Element(next[0]));
			}
		}

		System.out.println(get(elements, "a"));
	}

	@VisibleForTesting
	static class Element {
		private final String source;
		private Integer value;

		public Element(String source) {
			this.source = source;
		}

	}

	@VisibleForTesting
	static int get(Map<String, Element> elements, String element) {
		Integer i = Ints.tryParse(element);
		if (i != null) {
			return i;
		}

		Element source = elements.get(element);
		Objects.requireNonNull(source, "No input for element " + element);
		if (source.value != null) {
			return source.value;
		}

		int result;
		if (source.source.contains("NOT")) {
			result = not(elements, source.source);
		} else if (source.source.contains("AND")) {
			result = and(elements, source.source);
		} else if (source.source.contains("OR")) {
			result = or(elements, source.source);
		} else if (source.source.contains("LSHIFT")) {
			result = lshift(elements, source.source);
		} else if (source.source.contains("RSHIFT")) {
			result = rshift(elements, source.source);
		} else {
			result = get(elements, source.source);
		}
		// source.value = result;
		return result;
	}

	private static Integer rshift(Map<String, Element> elements, String source) {
		String[] split = source.split(" RSHIFT ");
		Integer first = get(elements, split[0]);
		Integer second = get(elements, split[1]);
		return first >> second;
	}

	private static Integer lshift(Map<String, Element> elements, String source) {
		String[] split = source.split(" LSHIFT ");
		Integer first = get(elements, split[0]);
		Integer second = get(elements, split[1]);
		return first << second;
	}

	private static Integer or(Map<String, Element> elements, String source) {
		String[] split = source.split(" OR ");
		Integer first = get(elements, split[0]);
		Integer second = get(elements, split[1]);
		return first | second;
	}

	private static Integer and(Map<String, Element> elements, String source) {
		String[] split = source.split(" AND ");
		Integer first = get(elements, split[0]);
		Integer second = get(elements, split[1]);
		return first & second;
	}

	private static Integer not(Map<String, Element> elements, String source) {
		String element = source.substring("NOT ".length());
		int value = get(elements, element);
		return ~value & 0xffff;
	}
}
