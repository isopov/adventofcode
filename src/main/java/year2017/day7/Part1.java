package year2017.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Part1 {
	public static void main(String[] args) {
		Map<String, Program> map = new HashMap<>();
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input")))
				.lines()) {

			lines.forEach(line -> {
				String[] split = line.split(" -> ");
				Program parent = map.computeIfAbsent(split[0].split(" ")[0], Program::new);
				if (split.length > 1) {
					for (String childName : split[1].split(", ")) {
						Program child = map.computeIfAbsent(childName, Program::new);
						child.parent = parent;
					}
				}
			});
		}
		
		System.out.println(map.values().stream().filter(Program::root).findAny().get().name);
	}

	static class Program {
		private final String name;
		private Program parent;

		public Program(String name) {
			this.name = name;
		}

		public boolean root() {
			return parent == null;
		}

	}

}
