package year2017.day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		System.out.println(minDistanceToZero(getInput()));
	}

	static List<String> getInput() {
		try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"))) {
			List<String> input = new ArrayList<>();
			while (scanner.hasNext()) {
				input.add(scanner.nextLine());
			}
			return input;
		}
	}

	static int minDistanceToZero(List<String> input) {
		List<Particle> particles = getParticles(input);

		return particles.stream()
				.sorted(Comparator.comparing(Particle::getA, Vec.ABS_COMPARATOR)
						.thenComparing(Comparator.comparing(Particle::getV, Vec.ABS_COMPARATOR))
						.thenComparing(Comparator.comparing(Particle::getP, Vec.ABS_COMPARATOR)))
				.findFirst().get().id;
	}

	static List<Particle> getParticles(List<String> input) {
		List<Particle> particles = new ArrayList<>(input.size());
		for (int i = 0; i < input.size(); i++) {
			particles.add(new Particle(i, input.get(i)));
		}
		return particles;
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

		public void step() {
			v.plus(a);
			p.plus(v);
		}

		public int getId() {
			return id;
		}

		public Vec getV() {
			return v;
		}

		public Vec getP() {
			return p;
		}

		public Vec getA() {
			return a;
		}

		@Override
		public String toString() {
			return String.valueOf(id);
		}
	}

	static class Vec {
		static final Comparator<Vec> ABS_COMPARATOR = Comparator.comparing(Vec::abs);

		private int x, y, z;

		public Vec(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getZ() {
			return z;
		}

		int abs() {
			return Math.abs(x) + Math.abs(y) + Math.abs(z);
		}

		void plus(Vec other) {
			x = Math.addExact(x, other.x);
			y = Math.addExact(y, other.y);
			z = Math.addExact(z, other.z);
		}

		static Vec fromString(String line) {
			String[] split = line.split(",");
			return new Vec(Integer.valueOf(split[0].trim()), Integer.valueOf(split[1].trim()),
					Integer.valueOf(split[2].trim()));
		}

		//DANGER! equals/hashCode for mutable state
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			result = prime * result + z;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vec other = (Vec) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			if (z != other.z)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "<" + x + "," + y + "," + z + ">";
		}
	}

}
