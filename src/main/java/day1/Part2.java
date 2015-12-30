package day1;

import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part2.class.getResourceAsStream("day1-input"));
		String input = scanner.next();

		int counter = 1;
		int floor = 1;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				floor++;
			} else {
				floor--;
				if (floor == 0) {
					System.out.println(counter);
					break;
				}
			}
			counter++;
		}

	}
}
