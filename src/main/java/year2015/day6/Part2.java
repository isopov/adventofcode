package year2015.day6;

import java.util.Scanner;

import com.google.common.annotations.VisibleForTesting;

public class Part2 {

	private static final int SIZE = 1000;
	private final int[][] lights = new int[SIZE][];

	public Part2() {
		for (int i = 0; i < lights.length; i++) {
			lights[i] = new int[SIZE];
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(Part2.class.getResourceAsStream("day6-input"))) {
			Part2 foo = new Part2();
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
				result = Math.addExact(result, lights[i][j]);
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
				lights[i][j] += 2;
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
				if (on) {
					lights[i][j]++;
				} else {
					lights[i][j]--;
					if (lights[i][j] < 0) {
						lights[i][j] = 0;
					}
				}

			}
		}
	}
}
