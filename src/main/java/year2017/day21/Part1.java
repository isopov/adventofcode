package year2017.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		System.out.println(numberOfPixels(getInput(), 5));
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

	static int numberOfPixels(List<String> input, int iterations) {

		return 0;
	}

	static Map<Pattern, Pattern> toPatterns(List<String> input) {
		Map<Pattern, Pattern> result = new HashMap<>();
		for (String line : input) {

		}

		return result;
	}

	static Pattern[][] divide(Pattern[][] patterns) {
		if (patterns[0][0].pixels.length == 4) {
			Pattern[][] result = new Pattern[patterns.length * 2][];
			for (int i = 0; i < patterns.length; i++) {
				result[i * 2] = new Pattern[patterns.length * 2];
				result[i * 2 + 1] = new Pattern[patterns.length * 2];
				for (int j = 0; j < patterns.length; j++) {
					boolean[][] pixels = patterns[i][j].pixels;
					result[i * 2][j * 2] = new Pattern(pixels[0][0], pixels[0][1], pixels[1][0], pixels[1][1]);
					result[i * 2 + 1][j * 2] = new Pattern(pixels[2][0], pixels[2][1], pixels[3][0], pixels[3][1]);
					result[i * 2][j * 2 + 1] = new Pattern(pixels[0][2], pixels[0][3], pixels[1][2], pixels[1][3]);
					result[i * 2 + 1][j * 2 + 1] = new Pattern(pixels[2][2], pixels[2][3], pixels[3][2], pixels[3][3]);
				}
			}
			return result;
		} else if (patterns[0][0].pixels.length == 3 && patterns.length % 2 == 0) {
			int length = (patterns.length / 2) * 3;
			Pattern[][] result = new Pattern[length][];
			for (int i = 0; i < patterns.length; i += 2) {
				int ibase = (i / 2) * 3;
				result[ibase] = new Pattern[length];
				result[ibase + 1] = new Pattern[length];
				result[ibase + 2] = new Pattern[length];
				for (int j = 0; j < patterns.length; j += 2) {
					boolean[][] pixels00 = patterns[i][j].pixels;
					boolean[][] pixels10 = patterns[i + 1][j].pixels;
					boolean[][] pixels01 = patterns[i][j + 1].pixels;
					boolean[][] pixels11 = patterns[i + 1][j + 1].pixels;
					int jbase = j / 2 * 3;
					result[ibase][jbase] = new Pattern(pixels00[0][0], pixels00[0][1], pixels00[1][0], pixels00[1][1]);
					result[ibase+1][jbase] = new Pattern(pixels00[0][2], pixels01[0][0], pixels00[1][2], pixels01[1][0]);
					result[ibase+2][jbase] = new Pattern(pixels01[0][1], pixels01[0][2], pixels01[1][1], pixels01[1][2]);
					
					result[ibase][jbase + 1] = new Pattern(pixels00[2][0], pixels00[2][1], pixels10[0][0], pixels10[0][1]);
					result[ibase + 1][jbase + 1] = new Pattern(pixels00[2][2], pixels01[2][0], pixels10[0][2], pixels11[0][0]);
					result[ibase + 2][jbase + 1] = new Pattern(pixels01[2][1], pixels01[2][2], pixels11[0][1], pixels11[0][2]);
					
					result[ibase][jbase + 2] = new Pattern(pixels10[1][0], pixels10[1][1], pixels10[2][0], pixels10[2][1]);
					result[ibase + 1][jbase + 2] = new Pattern(pixels01[1][2], pixels11[1][0], pixels01[2][2], pixels11[2][0]);
					
					//TODO
					result[ibase + 2][jbase + 2] = new Pattern(pixels00[0][0], pixels00[0][1], pixels00[1][0], pixels00[1][1]);
				}
			}

		} else {
			throw new IllegalArgumentException();
		}
	}

	static class Pattern {
		final boolean[][] pixels;

		public Pattern(boolean x11, boolean x12, boolean x21, boolean x22) {
			this.pixels = new boolean[][] { { x11, x12 }, { x21, x22 } };
		}

		public Pattern(boolean[][] pixels) {
			this.pixels = pixels;
		}

		public Pattern(String line) {
			line = line.replaceAll("/", "");
			switch (line.length()) {
			case 4:
				pixels = parsePixels(line, 2);
				break;
			case 9:
				pixels = parsePixels(line, 3);
				break;
			case 16:
				pixels = parsePixels(line, 4);
				break;
			default:
				throw new IllegalArgumentException();
			}
		}

		private static boolean[][] parsePixels(String line, int size) {
			boolean[][] pixels = new boolean[size][];
			for (int i = 0; i < line.length(); i++) {
				if (pixels[i / size] == null) {
					pixels[i / size] = new boolean[size];
				}
				pixels[i / size][i % size] = (line.charAt(i) == '#');
			}
			return pixels;
		}

		public Pattern rotate() {

			int length = pixels.length;
			boolean[][] rotated = new boolean[length][];

			for (int i = 0; i < length; ++i) {
				rotated[i] = new boolean[length];
				for (int j = 0; j < length; ++j) {
					rotated[i][j] = pixels[length - j - 1][i];
				}
			}
			return new Pattern(rotated);
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < pixels.length; i++) {
				if (i != 0) {
					result.append('/');
				}
				for (int j = 0; j < pixels.length; j++) {
					if (pixels[i][j]) {
						result.append('#');
					} else {
						result.append('.');
					}
				}
			}
			return result.toString();
		}

		@Override
		public int hashCode() {
			return Arrays.deepHashCode(pixels);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pattern other = (Pattern) obj;
			if (!Arrays.deepEquals(pixels, other.pixels))
				return false;
			return true;
		}
	}

}
