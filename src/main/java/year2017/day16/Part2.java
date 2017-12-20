package year2017.day16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		String input = scanner.next();
		char[] programs = Part1.programs(16);
		Map<String, Integer> cash = new HashMap<>();
		for (int i = 0; i < 1_000_000_000; i++) {
			Part1.dance(programs, input);
			Integer prev = cash.put(new String(programs), i);
			if (prev != null) {
				int cycle = i - prev;
				while (i + cycle < 1_000_000_000) {
					i += cycle;
				}
			}
		}
		System.out.println(new String(programs));

	}
}
