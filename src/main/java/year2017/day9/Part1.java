package year2017.day9;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		String input = scanner.next();

		System.out.println(score(input));

	}

	static int score(String input) {
		input = removeGarbage(input);
		int result = 0;
		int current = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '{') {
				current++;
				result += current;
			} else if (c == '}') {
				current--;
			}
		}

		return result;
	}

	static String removeScreened(String input) {
		StringBuilder result = new StringBuilder(input.length());
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '!') {
				i++;
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	static String removeGarbage(String input) {
		input = removeScreened(input);
		StringBuilder result = new StringBuilder(input.length());
		boolean garbage = false;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '<') {
				garbage = true;
			} else if (c == '>' && garbage) {
				garbage = false;
			} else if (!garbage) {
				result.append(c);
			}
		}
		return result.toString();
	}
}
