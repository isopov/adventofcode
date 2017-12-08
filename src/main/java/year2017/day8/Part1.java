package year2017.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Part1 {

	public static void main(String[] args) {

		Map<String, Register> map = new HashMap<>();

		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input")))
				.lines()) {
			lines.forEach(line -> {

				String[] split = line.split(" ");

				int condition = map.computeIfAbsent(split[4], Register::new).getValue();
				int operand = Integer.valueOf(split[6]);
				switch (split[5]) {
				case ">":
					if (condition <= operand) {
						return;
					} else {
						break;
					}
				case ">=":
					if (condition < operand) {
						return;
					} else {
						break;
					}
				case "==":
					if (condition != operand) {
						return;
					} else {
						break;
					}
				case "<":
					if (condition >= operand) {
						return;
					} else {
						break;
					}
				case "<=":
					if (condition > operand) {
						return;
					} else {
						break;
					}
				case "!=":
					if (condition == operand) {
						return;
					} else {
						break;
					}
				default:
					throw new IllegalStateException();
				}
				Register target = map.computeIfAbsent(split[0], Register::new);
				int value = Integer.valueOf(split[2]);
				if ("dec".equals(split[1])) {
					value *= -1;
				}
				target.plus(value);
			});
		}

		int max = map.values().stream().mapToInt(Register::getValue).max().getAsInt();
		System.out.println(max);
	}
	
	static class Register {
		private final String name;
		private int value = 0;

		public Register(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void plus(int value) {
			this.value += value;
		}
	}
	
}


