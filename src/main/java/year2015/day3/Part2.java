package year2015.day3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Part2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part2.class.getResourceAsStream("day3-input"));
		String input = scanner.next();

		Set<House> result = new HashSet<>();
		int santax = 0, santay = 0;
		int robox = 0, roboy = 0;
		result.add(new House(0, 0));
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) {
				switch (input.charAt(i)) {
				case '>':
					santax++;
					break;
				case '<':
					santax--;
					break;
				case '^':
					santay++;
					break;
				case 'v':
					santay--;
					break;
				default:
					throw new IllegalStateException();
				}
				result.add(new House(santax, santay));
			} else {
				switch (input.charAt(i)) {
				case '>':
					robox++;
					break;
				case '<':
					robox--;
					break;
				case '^':
					roboy++;
					break;
				case 'v':
					roboy--;
					break;
				default:
					throw new IllegalStateException();
				}
				result.add(new House(robox, roboy));
			}

		}
		System.out.println(result.size());

	}

	private static final class House {
		private final int x, y;

		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			House other = (House) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

}
