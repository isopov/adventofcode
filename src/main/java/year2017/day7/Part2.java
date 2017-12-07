package year2017.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part2 {
	public static void main(String[] args) {
		Map<String, Program> map = new HashMap<>();
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input")))
				.lines()) {

			lines.forEach(line -> {
				String[] split = line.split(" -> ");
				String[] splitWithWeight = split[0].split(" ");
				Program parent = map.computeIfAbsent(splitWithWeight[0], Program::new);
				int weight = weight(splitWithWeight[1]);
				parent.weight = weight;
				if (split.length > 1) {
					for (String childName : split[1].split(", ")) {
						Program child = map.computeIfAbsent(childName, Program::new);
						child.parent = parent;
						parent.children.add(child);
					}
				}
			});
		}

		Program root = map.values().stream().filter(Program::root).findAny().get();
		Program unbalanced = unbalanced(root);
		Map<Integer, List<Program>> collect = unbalanced.children.stream()
				.collect(Collectors.groupingBy(Program::totalWeight));

		Program target = collect.values().stream().filter(l -> l.size() == 1).findAny().get().get(0);
		int balanceWeight = collect.values().stream().filter(l -> l.size() > 1).findAny().get().get(0).totalWeight();
		int result = balanceWeight - (target.totalWeight() - target.weight);
		System.out.println(result);
	}

	private static Program unbalanced(Program root) {
		Program unbalanced = root;
		do {
			root = unbalanced;
			unbalanced = root.children.stream().filter(Program::unBalanced).findAny().orElse(null);
		} while (unbalanced != null);
		return root;
	}

	static int weight(String weightWithBrackets) {
		return Integer.valueOf(weightWithBrackets.substring(1, weightWithBrackets.length() - 1));
	}

	static class Program {
		private final String name;
		private final List<Program> children = new ArrayList<>();
		private Program parent;
		private int weight;
		private int totalWeight = Integer.MIN_VALUE;

		public Program(String name) {
			this.name = name;
		}

		public boolean root() {
			return parent == null;
		}

		public int totalWeight() {
			if (totalWeight != Integer.MIN_VALUE) {
				return totalWeight;
			}
			int totalWeight = weight;
			for (Program child : children) {
				totalWeight += child.totalWeight();
			}
			return totalWeight;
		}

		public boolean unBalanced() {
			return children.stream()
					.mapToInt(Program::totalWeight)
					.distinct().count() > 1;
		}
	}

}
