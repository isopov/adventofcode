package year2017.day11;

import java.util.Scanner;

public class Part1 {
	// https://www.redblobgames.com/grids/hexagons/
	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		String input = scanner.next();

		System.out.println(steps(input));
	}

	static int steps(String input) {

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
		}

		return steps(x, y);
	}

	static int steps(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);
		return Math.max(x, y);
	}

}
