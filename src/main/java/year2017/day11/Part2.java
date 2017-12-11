package year2017.day11;

import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part2.class.getResourceAsStream("input"));
		String input = scanner.next();

		System.out.println(steps(input));
	}

	static int steps(String input) {

		int max = 0;
		int x = 0, y = 0;
		for (String dir : input.split(",")) {
			switch (dir) {
			case "n":
				y--;
				break;
			case "ne":
				x++;
				y--;
				break;
			case "se":
				x++;
				break;
			case "s":
				y++;
				break;
			case "sw":
				x--;
				y++;
				break;
			case "nw":
				x--;
				break;
			}
			max = Math.max(steps(x, y), max);
		}

		return max;
	}

	static int steps(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);
		return Math.max(x, y);
	}

}
