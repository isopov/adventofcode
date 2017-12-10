package year2017.day9;

import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		String input = scanner.next();

		System.out.println(difLengths(input));
	}

	static int difLengths(String input) {
		input = removeScreened(input);
		return input.length() - removeGarbage(input).length(); 
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
				if (!garbage) {
					result.append(c);
				}
				garbage = true;

			} else if (c == '>' && garbage) {
				garbage = false;
				result.append(c);
			} else if (!garbage) {
				result.append(c);
			}
		}
		return result.toString();
	}
}
