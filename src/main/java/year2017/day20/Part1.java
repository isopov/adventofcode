package year2017.day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		List<String> input = new ArrayList<>();
		while (scanner.hasNext()) {
			input.add(scanner.nextLine());
		}

		System.out.println(minDistanceToZero(input));
	}

	static int minDistanceToZero(List<String> input) {
		List<Particle> particles = new ArrayList<>(input.size());
		for (int i = 0; i < input.size(); i++) {
			particles.add(new Particle(i, input.get(i)));
		}

		return particles.stream().sorted(
				Comparator.comparing(Particle::getAbsA)
						.thenComparing(Comparator.comparing(Particle::getAbsV))
						.thenComparing(Comparator.comparing(Particle::getAbsP)))
				.findFirst().get().id;
	}

	static class Particle {
		final int id;
		final Vec p, v, a;

		public Particle(int id, String line) {
			this.id = id;
			String[] split = line.split("[<>]");
			p = Vec.fromString(split[1]);
			v = Vec.fromString(split[3]);
			a = Vec.fromString(split[5]);
		}

		public int getId() {
			return id;
		}

		public int getAbsP() {
			return p.abs();
		}

		public int getAbsV() {
			return v.abs();
		}

		public int getAbsA() {
			return a.abs();
		}

	}

	static class Vec {
		private int x, y, z;

		public Vec(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		int abs() {
			return Math.abs(x) + Math.abs(y) + Math.abs(z);
		}

		static Vec fromString(String line) {
			String[] split = line.split(",");
			return new Vec(
					Integer.valueOf(split[0].trim()),
					Integer.valueOf(split[1].trim()),
					Integer.valueOf(split[2].trim()));
		}
	}

}
