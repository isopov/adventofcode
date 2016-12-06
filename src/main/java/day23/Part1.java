package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		List<Instruction> instructions = new ArrayList<>();
		try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day23-input"))) {
			int index = 0;
			while (scanner.hasNextLine()) {
				instructions.add(new Instruction(index, scanner.nextLine()));
				index++;
			}
		}

		Memory memory = new Memory();

		int step = 0;
		int index = 0;
		while (index >= 0 && index < instructions.size()) {
			// System.out.println(step + ": " + index + " " + memory.a + " " +
			// memory.b);
			index = instructions.get(index).nextIndex(memory);
			step++;
			// if (step > 200) {
			// break;
			// }

		}
		System.out.println(memory.b);

	}

	private static class Memory {
		public int a = 1, b;
	}

	private static class Instruction {
		private final int index;
		private final String value;

		public Instruction(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int nextIndex(Memory memory) {
			if (value.startsWith("hlf")) {
				if (value.endsWith("a")) {
					memory.a /= 2;
				} else {
					memory.b /= 2;
				}
				return index + 1;
			} else if (value.startsWith("tpl")) {
				if (value.endsWith("a")) {
					memory.a *= 3;
				} else {
					memory.b *= 3;
				}
				return index + 1;
			} else if (value.startsWith("inc")) {
				if (value.endsWith("a")) {
					memory.a++;
				} else {
					memory.b++;
				}
				return index + 1;
			} else if (value.startsWith("jmp")) {
				return index + Integer.parseInt(value.split(" ")[1]);
			} else if (value.startsWith("jie")) {
				String[] val = value.split(", ");
				String slot = val[0].split(" ")[1];
				switch (slot) {
				case "a":
					if (memory.a % 2 != 0) {
						return index + 1;
					}
					break;
				case "b":
					if (memory.b % 2 != 0) {
						return index + 1;
					}
					break;
				default:
					throw new IllegalArgumentException();
				}
				return index + Integer.parseInt(val[1]);
			} else if (value.startsWith("jio")) {
				String[] val = value.split(", ");
				String slot = val[0].split(" ")[1];
				switch (slot) {
				case "a":
					if (memory.a != 1) {
						return index + 1;
					}
					break;
				case "b":
					if (memory.b != 1) {
						return index + 1;
					}
					break;
				default:
					throw new IllegalArgumentException();
				}
				return index + Integer.parseInt(val[1]);
			}

			throw new IllegalArgumentException();
		}

	}

}
