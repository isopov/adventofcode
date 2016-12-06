package year2015.day6;

import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;

public class Part1 {

	private static final int SIZE = 1000;
	private final boolean[][] lights = new boolean[SIZE][];

	public Part1() {
		for (int i = 0; i < lights.length; i++) {
			lights[i] = new boolean[SIZE];
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day6-input"))) {
			Part1 foo = new Part1();
			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				foo.execute(nextLine);
			}
			System.out.println(foo.countOn());
		}
	}

	@VisibleForTesting
	void execute(String nextLine) {
		String[] instruction = nextLine.split(" ");
		switch (instruction[0]) {
		case "turn":
			turn(instruction);
			break;
		case "toggle":
			toggle(instruction);
			break;
		default:
			throw new IllegalStateException();
		}
	}

	@VisibleForTesting
	int countOn() {
		int result = 0;
		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights.length; j++) {
				if (lights[i][j]) {
					result++;
				}
			}
		}
		return result;
	}

	private void toggle(String[] instruction) {
		String[] first = instruction[1].split(",");
		int x1 = Integer.valueOf(first[0]), y1 = Integer.valueOf(first[1]);
		String[] second = instruction[3].split(",");
		int x2 = Integer.valueOf(second[0]), y2 = Integer.valueOf(second[1]);

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				lights[i][j] = !lights[i][j];
			}
		}
	}

	private void turn(String[] instruction) {
		boolean on = instruction[1].equals("on");
		String[] first = instruction[2].split(",");
		int x1 = Integer.valueOf(first[0]), y1 = Integer.valueOf(first[1]);
		String[] second = instruction[4].split(",");
		int x2 = Integer.valueOf(second[0]), y2 = Integer.valueOf(second[1]);

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				lights[i][j] = on;
			}
		}
	}
}
