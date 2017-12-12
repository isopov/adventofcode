package year2017.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;

public class Part1 {

	public static void main(String[] args) {
		try (Stream<String> lines = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input")))
				.lines()) {
			System.out.println(zeroGroup(lines));
		}
	}

	static int zeroGroup(Stream<String> lines) {

		MutableIntObjectMap<Program> programs = new IntObjectHashMap<>();

		lines.forEach(line -> {
			String[] split = line.split(" <-> ");
			Program program = programs.getIfAbsentPutWithKey(Integer.valueOf(split[0]), Program::new);

			for (String connectionId : split[1].split(", ")) {
				Program connection = programs.getIfAbsentPutWithKey(Integer.valueOf(connectionId), Program::new);
				program.connections.add(connection.id);
				connection.connections.add(program.id);

			}
		});

		boolean[] added = { false };
		MutableIntSet zeroGroup = new IntHashSet();
		zeroGroup.addAll(programs.get(0).connections);
		do {
			added[0] = false;
			zeroGroup.forEach(con -> {
				added[0] |= zeroGroup.addAll(programs.get(con).connections);
			});
		} while (added[0]);

		return zeroGroup.size();
	}

	static class Program {
		private final int id;
		private final MutableIntSet connections = new IntHashSet();

		public Program(int id) {
			this.id = id;
		}
	}

}
